package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.TalentShukanShutsuenJohoBFFApi;
import com.model.TalentShukanShutsuenJohoBFF;
import com.talent.service.TalentShukanShutsuenJohoBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TalentShukanShutsuenJohoBFFController implements TalentShukanShutsuenJohoBFFApi{
	
	// TalentShukanShutsuenJohoBFFServiceを宣言
    private final TalentShukanShutsuenJohoBFFService service;
    
    /**
     * タレント週間出演情報検索Controller
     *
     * @param nentsuki  年月
     * @param shu       週
     * @param talentId タレントID
     * @return TalentShukanShutsuenJohoBFF
     */
	@Override
	public ResponseEntity<TalentShukanShutsuenJohoBFF> getTalentShukanShutsuenJohoBFF(Integer nentsuki, Integer shu,String talentId) {
		// TalentShukanShutsuenJohoBFFServiceより取得
		TalentShukanShutsuenJohoBFF response  = service.getTalentShukanShutsuenJohoBFF(nentsuki, shu, talentId);
		return ResponseEntity.ok(response);
	}
}