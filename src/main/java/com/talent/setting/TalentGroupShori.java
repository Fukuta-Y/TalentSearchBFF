package com.talent.setting;

import com.model.MProgram;
import com.model.MTalent;
import com.model.TOnAirKanri;
import com.talent.service.dto.OnairKanriInfoDto;
import com.talent.service.dto.TalentShutsuenHonsuDto;
import com.talent.service.helper.ShukanTalentJohoBffHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TalentGroupShori {

    @Autowired
    private Utils utils;
    @Autowired
    private ShukanTalentJohoBffHelper helper;

    public List<OnairKanriInfoDto> setOnairKanriInfoList(List<MTalent> modelTalentList, List<MProgram> modelProgramList, List<TOnAirKanri> OnAionarKanriInfoList) {

        // タレント名、番号名をレスポンスに設定する。
        // 突き合わせができなかった、「オンエア管理テーブルDTO」の行については名称系を未設定とする。
        List<OnairKanriInfoDto> response = new ArrayList<OnairKanriInfoDto>();
        for (TOnAirKanri e : OnAionarKanriInfoList) {
            // OnairKanriInfoDtoへ変換して設定
            response.add(helper.toOnairKanriInfoDto(e,
                    utils.fetchTalentName(e, modelTalentList),
                    utils.fetchProgramName(e, modelProgramList)));
        }
        return response;
    }

    public List<TalentShutsuenHonsuDto> setTalentShutsuenHonsuList(List<OnairKanriInfoDto> OnairKanriInfoList) {
        List<TalentShutsuenHonsuDto> TalentShutsuenHonsuList = new ArrayList<TalentShutsuenHonsuDto>();
        for (OnairKanriInfoDto e : OnairKanriInfoList) {
            // TalentShutsuenHonsuDtoへ変換して設定
            TalentShutsuenHonsuList.add(helper.toTalentShutsuenHonsuDto(e));
        }
        return TalentShutsuenHonsuList;
    }

    public List<TalentShutsuenHonsuDto> setTalentShutsuenHonsuCountList(List<TalentShutsuenHonsuDto> TalentShutsuenHonsuList) {
        Map<TalentShutsuenHonsuDto, Long> dtoCount =
                TalentShutsuenHonsuList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<TalentShutsuenHonsuDto> TalentShutsuenHonsuCountList = new ArrayList<TalentShutsuenHonsuDto>();
        dtoCount.forEach((k, v) -> {
            // TalentShutsuenHonsuListのTalentShutsuenHonsuDtoごとの本数をTalentShutsuenHonsuCountListへ設定
            TalentShutsuenHonsuCountList.add(helper.toTalentShutsuenHonsuDto(k, v));
        });
        return TalentShutsuenHonsuCountList;
    }
}
