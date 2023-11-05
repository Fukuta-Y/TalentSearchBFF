package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.TalentInfoBFFApi;
import com.model.TalentInfo;
import com.talent.service.TalentMasterBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TalentInfoBFFController implements TalentInfoBFFApi{

	// TalentMasterBFFServiceを宣言
	private final TalentMasterBFFService service;
	
	 /**
	  * タレント情報BFFController
	  *
	  * @param talentId タレントID
	  * @return TalentInfo
	  * 
	 */
	@Override
	public ResponseEntity<TalentInfo> getTalentInfoBFF(String talentId) {
		// TalentMasterBFFServiceより取得
		TalentInfo response = service.getTalentInfo(talentId);
		return ResponseEntity.ok(response);
	}

}