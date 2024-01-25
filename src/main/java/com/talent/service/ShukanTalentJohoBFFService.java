package com.talent.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.model.MProgram;
import com.model.MTalent;
import com.model.ShukanTalent;
import com.model.ShukanTalentJoho;
import com.model.ShukanTalentJohoBFF;
import com.model.TOnAirKanri;
import com.model.YearMonthWeekStartEndJoho;
import com.talent.service.dto.OnAirKanriInfoDto;
import com.talent.service.dto.TalentInfoDto;
import com.talent.service.dto.TalentOnAirChokinInfoDto;
import com.talent.service.dto.TalentShutsuenHonsuDto;
import com.talent.service.helper.ShukanTalentJohoBffHelper;
import com.talent.setting.OnAirComparator;
import com.talent.setting.TalentGroupShori;
import com.talent.setting.TalentIdComparator;
import com.talent.setting.WebClientInfo;

import lombok.RequiredArgsConstructor;

/**
 * 週間タレント別情報検索Service
 */
@Service
@RequiredArgsConstructor
public class ShukanTalentJohoBFFService {

	// WebClientInfoを宣言
    private final WebClientInfo webClient;
    
	// ShukanTalentJohoBffHelperを宣言
    private final ShukanTalentJohoBffHelper helper;
    
	// TalentGroupShoriを宣言
    private final TalentGroupShori groupShori;

    /**
     * 週間タレント別情報検索Service
     *
     * @param nentsuki   年月
     * @param shu        週
     * @param talentName タレント名
     * @return List<ShukanTalentJohoBFF>
     */
    public ShukanTalentJohoBFF getShukanTalentJohoBFF(Integer nentsuki, Integer shu, String talentName) {

    	// reponseを宣言
    	ShukanTalentJohoBFF response = new ShukanTalentJohoBFF();
        // Listに設定するModelの宣言
    	List<ShukanTalent> listShukanTalentJoho = new ArrayList<ShukanTalent>();
    	ShukanTalent shukanTalent = new ShukanTalent();

        // BE「週間タレント別情報検索より取得処理
        ShukanTalentJoho talentJoho = this.webClient.getShukanTalentJoho(nentsuki, shu, talentName);
        // 各テーブルごとの内容を取得
        List<TOnAirKanri> modelOnAirKanriList = talentJoho.gettOnAirKanri();
        List<MTalent> modelTalentList = talentJoho.getmTalent();
        List<MProgram> modelProgramList = talentJoho.getmProgram();

        // (1) BE「週間タレント別情報検索」より取得したレスポンスで以下の条件でデータを絞る。
        // （別シート_タレント出演情報検索の結合イメージ　参照）
        // 以下はオンエア管理が設定されている場合のみ対応
        if (CollectionUtils.isEmpty(modelOnAirKanriList)) {
        	response.addShukanTalentItem(shukanTalent);
            return response;
        }
        List<OnAirKanriInfoDto> OnAirKanriInfoList = groupShori.setOnAirKanriInfoList(modelTalentList, modelProgramList, modelOnAirKanriList);
        // (2) 絞った結果をタレントID、タレント名で集約化する。集約時に、タレントID,タレント名、週間出演番組本数のレコードの形にする。
        // （レスポンスのベース）
        List<TalentShutsuenHonsuDto> talentShutsuenHonsuList = groupShori.setTalentShutsuenHonsuList(OnAirKanriInfoList);
        List<TalentShutsuenHonsuDto> talentShutsuenHonsuCountList = groupShori.setTalentShutsuenHonsuCountList(talentShutsuenHonsuList);
        // (3)　(1)よりタレントIDをキーとして取得して、オンエア日でソートして、最も近いオンエア日の日付の行だけを取得する。
        // 取得後、タレントID、出演番組（直近）【番組名】、オンエア日（直近）【オンエア日】のレコードの形にする。
        List<String> talentList = new ArrayList<String>();
        // タレントIDの一覧のリスト
        for (TalentShutsuenHonsuDto e : talentShutsuenHonsuCountList) {
            talentList.add(e.getTalent().getId());
        }

        List<TalentOnAirChokinInfoDto> talentOnairChokinInfoDtoList = new ArrayList<TalentOnAirChokinInfoDto>();
        List<OnAirKanriInfoDto> OnAirKanriInfosDto = new ArrayList<OnAirKanriInfoDto>();

        for (String talentID : talentList) {
            OnAirKanriInfosDto = new ArrayList<OnAirKanriInfoDto>();
            for (OnAirKanriInfoDto e : OnAirKanriInfoList) {
                if (StringUtils.equals(e.getTalent().getId(), talentID)) {
                    OnAirKanriInfosDto.add(e);
                }
            }
            if (CollectionUtils.isNotEmpty(OnAirKanriInfosDto)) {
                //オンエア日でソート
                OnAirKanriInfosDto.sort(new OnAirComparator());
                // TalentOnairChokinInfoDtoへ変換して設定
                talentOnairChokinInfoDtoList.add(helper.toTalentOnairChokinInfoDto(OnAirKanriInfosDto.get(0)));
            }
        }

        // (4) (2)に対して、(3)を組み合わせて、レスポンスの形にする。
        List<TalentInfoDto> talentInfoDtoList = new ArrayList<TalentInfoDto>();
        // TalentShutsuenHonsuCountListとtalentOnairChokinInfoDtoListをマージ
        for (TalentShutsuenHonsuDto k : talentShutsuenHonsuCountList) {
            for (TalentOnAirChokinInfoDto v : talentOnairChokinInfoDtoList) {
                if (StringUtils.equals(k.getTalent().getId(), v.getTalent().getId())) {
                	talentInfoDtoList.add(helper.toTalentInfoDto(k, v));
                    break;
                }
            }
        }

        // (5)BE「年月週の開始終了日付検索」より取得したレスポンスを以下のように設定する。
        // ・対象週(FROM)へ、年月週管理マスタDTO .週の開始日（日曜日）を設定
        // ・対象週(TO)へ、年月週管理マスタDTO .週の終了日（土曜日）を設定
        YearMonthWeekStartEndJoho yearMonthJoho = this.webClient.getYearMonthWeekStartEnd(nentsuki, shu);

        // (6) (4) + (5)を組み合わせて、レスポンスの形にする。
        for (TalentInfoDto e : talentInfoDtoList) {
        	int honsu = Math.toIntExact(e.getShukanShutsuenHonsu());
        	shukanTalent = helper.toShukanTalentJoho(e, honsu, yearMonthJoho.getmNentsukiShuKanri());
        	listShukanTalentJoho.add(shukanTalent);
        }

        // List<ShukanTalent>をIDの順にソート
        listShukanTalentJoho.sort(new TalentIdComparator());
        // responseに設定
        response.setShukanTalent(listShukanTalentJoho);

        // Responseへ設定
        return response;
    }
}