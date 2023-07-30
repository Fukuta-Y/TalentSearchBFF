package com.talent.setting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.MProgram;
import com.model.MTalent;
import com.model.TOnAirKanri;
import com.talent.service.dto.OnAirKanriInfoDto;
import com.talent.service.dto.TalentShutsuenHonsuDto;
import com.talent.service.helper.ShukanTalentJohoBffHelper;

/**
 * Listの設定用のクラス
 */
@Service
public class TalentGroupShori {

    @Autowired
    private Utils utils;
    @Autowired
    private ShukanTalentJohoBffHelper helper;

    /**
     * オンエア管理情報DTOのリストを作成する
     *
     * @param List<MTalent> modelTalentList　Model「MTalent」のリスト
     * @param List<MProgram> modelProgramList  Model「MProgram」のリスト
     * @param List<TOnAirKanri> OnAionarKanriInfoList  Model「TOnAirKanri」のリスト
     * @return List<OnAirKanriInfoDto>　オンエア管理情報DTOのリスト
     */
    public List<OnAirKanriInfoDto> setOnairKanriInfoList(
            List<MTalent> modelTalentList, List<MProgram> modelProgramList, List<TOnAirKanri> OnAionarKanriInfoList) {

        // タレント名、番号名をレスポンスに設定する。
        // 突き合わせができなかった、「オンエア管理テーブルDTO」の行については名称系を未設定とする。
        List<OnAirKanriInfoDto> response = new ArrayList<OnAirKanriInfoDto>();
        for (TOnAirKanri e : OnAionarKanriInfoList) {
            // OnairKanriInfoDtoへ変換して設定
            response.add(helper.toOnairKanriInfoDto(e,
                    utils.fetchTalentName(e, modelTalentList),
                    utils.fetchProgramName(e, modelProgramList)));
        }
        return response;
    }

    /**
     * タレント出演本数DTOのリストを作成する（出演本数は未設定）
     *
     * @param List<OnAirKanriInfoDto>　オンエア管理情報DTOのリスト
     * @return List<TalentShutsuenHonsuDto>　タレント出演本数DTOのリスト
     */	
    public List<TalentShutsuenHonsuDto> setTalentShutsuenHonsuList(List<OnAirKanriInfoDto> OnairKanriInfoList) {

        List<TalentShutsuenHonsuDto> countList = new ArrayList<TalentShutsuenHonsuDto>();
        for (OnAirKanriInfoDto e : OnairKanriInfoList) {
            // TalentShutsuenHonsuDtoへ変換して設定
        	countList.add(helper.toTalentShutsuenHonsuDto(e));
        }
        return countList;
    }

    /**
     * タレント出演本数DTOのリスト内の出演本数を設定
     *
     * @param List<TalentShutsuenHonsuDto>　タレント出演本数DTOのリスト
     * @return List<TalentShutsuenHonsuDto>　タレント出演本数DTOのリスト
     */	
    public List<TalentShutsuenHonsuDto> setTalentShutsuenHonsuCountList(List<TalentShutsuenHonsuDto> TalentShutsuenHonsuList) {
    	Map<TalentShutsuenHonsuDto, Long> dtoCount =
                TalentShutsuenHonsuList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<TalentShutsuenHonsuDto> countShutsuenList = new ArrayList<TalentShutsuenHonsuDto>();
        dtoCount.forEach((k, v) -> {
            // TalentShutsuenHonsuListのTalentShutsuenHonsuDtoごとの本数をcountShutsuenListへ設定
        	countShutsuenList.add(helper.toTalentShutsuenHonsuDto(k, v));
        });
        return countShutsuenList;
    }
}
