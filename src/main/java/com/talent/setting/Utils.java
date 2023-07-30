package com.talent.setting;


import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.model.MProgram;
import com.model.MTalent;
import com.model.TOnAirKanri;

@Service
public class Utils {
    /**
     * 条件に合致したタレント名を返す
     *
     * @param TOnAirKanri kanri  Model「TOnAirKanri」
     * @param List<MTalent> modelTalentList　Model「MTalent」のリスト
     * @return タレント名（合致しなかった場合は空文字を返す）
     */
    public String fetchTalentName(TOnAirKanri kanri, List<MTalent> modelTalentList) {
    	// Model「MTalent」のリストが設定済みの場合
        if (CollectionUtils.isNotEmpty(modelTalentList)) {
        	// Model「MTalent」のリストのタレントIDとModel「TOnAirKanri」のタレントIDが合致した場合、タレント名を設定
            return modelTalentList.stream()
                    .filter(e -> Objects.equals(e.getTalentId(), kanri.getTalentId()))
                    .findFirst()
                    .map(MTalent::getTalentName)
                    .orElse(StringUtils.EMPTY);
        }
        return StringUtils.EMPTY;
    }

    
    /**
     * 条件に合致した番組名を返す
     *
     * @param TOnAirKanri kanri  Model「TOnAirKanri」
     * @param List<MProgram> modelProgramList　Model「MProgram」のリスト
     * @return　番組名（合致しなかった場合は空文字を返す）
     */
    public String fetchProgramName(TOnAirKanri kanri, List<MProgram> modelProgramList) {
    	// Model「MProgram」のリストが設定済みの場合
        if (CollectionUtils.isNotEmpty(modelProgramList)) {
        	// Model「MProgram」のリストの番組IDとModel「TOnAirKanri」の番組IDが合致した場合、番組名を設定
            return modelProgramList.stream()
                    .filter(e -> Objects.equals(e.getProgramId(), kanri.getProgramId()))
                    .findFirst()
                    .map(MProgram::getProgramName)
                    .orElse(StringUtils.EMPTY);
        }
        return StringUtils.EMPTY;
    }
}