package com.talent.setting;


import com.model.MProgram;
import com.model.MTalent;
import com.model.TOnAirKanri;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class Utils {
    // 対象のオンエア管理とタレントIDが合致するかどうか
    public String fetchTalentName(TOnAirKanri kanri, List<MTalent> modelTalentList) {
        if (CollectionUtils.isNotEmpty(modelTalentList)) {
            return modelTalentList.stream()
                    .filter(e -> Objects.equals(e.getTalentId(), kanri.getProgramId()))
                    .findFirst()
                    .map(MTalent::getTalentName)
                    .orElse(StringUtils.EMPTY);
        }
        return StringUtils.EMPTY;
    }

    // 対象のオンエア管理と番組IDが合致するかどうか
    public String fetchProgramName(TOnAirKanri kanri, List<MProgram> modelProgramList) {
        if (CollectionUtils.isNotEmpty(modelProgramList)) {
            return modelProgramList.stream()
                    .filter(e -> Objects.equals(e.getProgramId(), kanri.getProgramId()))
                    .findFirst()
                    .map(MProgram::getProgramName)
                    .orElse(StringUtils.EMPTY);
        }
        return StringUtils.EMPTY;
    }
}