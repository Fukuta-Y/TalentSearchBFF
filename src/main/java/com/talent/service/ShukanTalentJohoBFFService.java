package com.talent.service;

import com.model.*;
import com.talent.service.dto.OnairKanriInfoDto;
import com.talent.service.dto.TalentInfoDto;
import com.talent.service.dto.TalentOnairChokinInfoDto;
import com.talent.service.dto.TalentShutsuenHonsuDto;
import com.talent.service.helper.ShukanTalentJohoBffHelper;
import com.talent.setting.OnAirComparator;
import com.talent.setting.TalentIdComparator;
import com.talent.setting.Utils;
import com.talent.setting.WebClientInfo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 週間タレント別情報検索 Service
 */
@Service
@RequiredArgsConstructor
public class ShukanTalentJohoBFFService {

    private final WebClientInfo webClient;
    private final Utils utils;
    private final ShukanTalentJohoBffHelper helper;

    /**
     * 週間タレント別情報検索
     *
     * @param nentsuki   対象年月
     * @param shu        対象週
     * @param talentName タレント名
     * @return 検索結果
     */
    public List<ShukanTalentJohoBFF> select(Integer nentsuki, Integer shu, String talentName) {

        List<ShukanTalentJohoBFF> response = new ArrayList<ShukanTalentJohoBFF>();
        ShukanTalentJohoBFF bffModel = new ShukanTalentJohoBFF();

        // BE「週間タレント別情報検索より取得処理
        ShukanTalentJoho talentJoho = this.webClient.getShukanTalentJoho(nentsuki, shu, talentName);

        // (1) BE「週間タレント別情報検索」より取得したレスポンスで以下の条件でデータを絞る。
        // （別シート_タレント出演情報検索の結合イメージ　参照）
        List<TOnAirKanri> modelOnAirKanriList = talentJoho.gettOnAirKanri();
        List<MTalent> modelTalentList = talentJoho.getmTalent();
        List<MProgram> modelProgramList = talentJoho.getmProgram();
        // 以下はオンエア管理が設定されている場合のみ対応
        if (CollectionUtils.isEmpty(modelOnAirKanriList)) {
            response.add(bffModel);
            return response;
        }
        // タレント名、番号名をレスポンスに設定する。
        // 突き合わせができなかった、「オンエア管理テーブルDTO」の行については名称系を未設定とする。
        List<OnairKanriInfoDto> OnairKanriInfoList = new ArrayList<OnairKanriInfoDto>();
        for (TOnAirKanri kanri : modelOnAirKanriList) {
            // GroupClassDto1へ変換して設定
            OnairKanriInfoList.add(helper.toDto1(kanri,
                    utils.fetchTalentName(kanri, modelTalentList),
                    utils.fetchProgramName(kanri, modelProgramList)));
        }

        // (2) 絞った結果をタレントID、タレント名で集約化する。集約時に、タレントID,タレント名、週間出演番組本数のレコードの形にする。
        // （レスポンスのベース）
        List<TalentShutsuenHonsuDto> TalentShutsuenHonsuList = new ArrayList<TalentShutsuenHonsuDto>();
        for (OnairKanriInfoDto dto1 : OnairKanriInfoList) {
            // GroupClassDto2へ変換して設定
            TalentShutsuenHonsuList.add(helper.toDto2(dto1));
        }

        // クラス単位での件数を取得
        Map<TalentShutsuenHonsuDto, Long> countMap =
                TalentShutsuenHonsuList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<TalentShutsuenHonsuDto> TalentShutsuenHonsuList2 = new ArrayList<TalentShutsuenHonsuDto>();
        countMap.forEach((dto2, count) -> {
            // GroupClassDto2の本数へ変換して設定
            TalentShutsuenHonsuList2.add(helper.toHonsuDto2(dto2, count));
        });

        // (3)　(1)よりタレントIDをキーとして取得して、オンエア日でソートして、最も近いオンエア日の日付の行だけを取得する。
        // 取得後、タレントID、出演番組（直近）【番組名】、オンエア日（直近）【オンエア日】のレコードの形にする。
        List<String> talentList = new ArrayList<String>();
        // タレントIDの一覧のリスト
        for (TalentShutsuenHonsuDto e : TalentShutsuenHonsuList2) {
            talentList.add(e.getTalent().getId());
        }

        List<TalentOnairChokinInfoDto> dto3List = new ArrayList<TalentOnairChokinInfoDto>();
        List<OnairKanriInfoDto> dto1List = new ArrayList<OnairKanriInfoDto>();

        for (String talentID : talentList) {
            dto1List = new ArrayList<OnairKanriInfoDto>();
            for (OnairKanriInfoDto dto1 : OnairKanriInfoList) {
                if (StringUtils.equals(dto1.getTalent().getId(), talentID)) {
                    dto1List.add(dto1);
                }
            }
            if (CollectionUtils.isNotEmpty(dto1List)) {
                //オンエア日でソート
                dto1List.sort(new OnAirComparator());
                // GroupClassDto3へ変換して設定
                dto3List.add(helper.toDto3(dto1List.get(0)));
            }
        }

        // (4) (2)に対して、(3)を組み合わせて、レスポンスの形にする。
        List<TalentInfoDto> dto4List = new ArrayList<TalentInfoDto>();
        // TalentShutsuenHonsuList2とdto3Listをマージ
        for (TalentShutsuenHonsuDto dto2 : TalentShutsuenHonsuList2) {
            for (TalentOnairChokinInfoDto dto3 : dto3List) {
                if (StringUtils.equals(dto2.getTalent().getId(), dto3.getTalent().getId())) {
                    dto4List.add(helper.toDto4(dto2, dto3));
                    break;
                }
            }
        }

        // (5)BE「年月週の開始終了日付検索」より取得したレスポンスを以下のように設定する。
        // ・対象週(FROM)へ、年月週管理マスタDTO .週の開始日（日曜日）を設定
        // ・対象週(TO)へ、年月週管理マスタDTO .週の終了日（土曜日）を設定
        YearMonthWeekStartEndJoho yearMonthJoho = this.webClient.getYearMonthWeekStartEnd(nentsuki, shu);

        // (6) (4) + (5)を組み合わせて、レスポンスの形にする。
        for (TalentInfoDto dto4 : dto4List) {
            response.add(helper.toResponse(dto4, Math.toIntExact(dto4.getShukanShutsuenHonsu()), yearMonthJoho.getmNentsukiShuKanri()));
        }

        // responseをIDの順にソート
        response.sort(new TalentIdComparator());

        // responseの返却
        return response;
    }
}