package com.talent.setting;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.model.MProgram;
import com.model.MTalent;
import com.model.TOnAirKanri;

// REVIEW: ここは変数名を変更した方がJAVA的には嬉しいかも
// - checkを接頭辞とした場合、booleanが返却されるのが一般的にであるため。(fetchなどの取得を意味する言葉の方が適切？)
@Service
public class CommonShori {
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
