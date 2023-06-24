package com.talent.setting;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.model.MProgram;
import com.model.MTalent;
import com.model.TOnAirKanri;

@Service
public class CommonShori {
    // 対象のオンエア管理とタレントIDが合致するかどうか
    public String checkTalentName(TOnAirKanri kanri, List<MTalent> modelTalentList) {
    	for(MTalent talent: modelTalentList) {
	  		if(StringUtils.equals(talent.getTalentId(), kanri.getTalentId())) {
	  			return talent.getTalentName();
			}
    	}
    	return StringUtils.EMPTY;
    }

    // 対象のオンエア管理と番組IDが合致するかどうか
    public String checkProgramName(TOnAirKanri kanri, List<MProgram> modelProgramList) {
    	for(MProgram program: modelProgramList) {
	  		if(StringUtils.equals(program.getProgramId(), kanri.getProgramId())) {
	  			return program.getProgramName();
			}
    	}
    	return StringUtils.EMPTY;
    }
}