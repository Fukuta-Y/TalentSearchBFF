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
public class Utils{
    // 対象のオンエア管理とタレントIDが合致するかどうか
    public String checkTalentName(TOnAirKanri kanri, List<MTalent> modelTalentList) {
    	if(Objects.nonNull(modelTalentList)) {
	    	for(MTalent talent: modelTalentList) {
		  		if(StringUtils.equals(talent.getTalentId(), kanri.getTalentId())) {
		  			return talent.getTalentName();
				}
	    	}
    	}
    	return StringUtils.EMPTY;
    }

	public String fetchTalentName(TOnAirKanri kanri, List<MTalent> modelTalentList) {
		if (CollectionUtils.isNotEmpty(modelTalentList)) {
			return modelTalentList.stream()
					.filter(e -> Objects.equals(e.getTalentId(), kanri))
					.findFirst()
					.map(MTalent::getTalentName)
					.orElse(StringUtils.EMPTY);
		}
		return StringUtils.EMPTY;
	}

    // 対象のオンエア管理と番組IDが合致するかどうか
    public String checkProgramName(TOnAirKanri kanri, List<MProgram> modelProgramList) {
    	if(Objects.nonNull(modelProgramList)) {
	    	for(MProgram program: modelProgramList) {
		  		if(StringUtils.equals(program.getProgramId(), kanri.getProgramId())) {
		  			return program.getProgramName();
				}
	    	}
    	}
    	return StringUtils.EMPTY;
    }
}