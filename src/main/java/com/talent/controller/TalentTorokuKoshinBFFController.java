package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.TalentTorokuKoshinBFFApi;
import com.model.MTalent;
import com.model.TalentTorokuKoshinBFF;
import com.talent.service.TalentTorokuKoshinBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TalentTorokuKoshinBFFController implements TalentTorokuKoshinBFFApi{

	// TalentTorokuKoshinBFFServiceを宣言
	private final TalentTorokuKoshinBFFService service;

	 /**
	  * タレント登録・更新BFFController
	  *
	  * @param mTalent タレントマスタDTO
	  * @return TalentTorokuKoshinBFF
	  * 
	 */
	@Override
	public ResponseEntity<TalentTorokuKoshinBFF> postTalentTorokuKoshinBFF(MTalent mTalent) {
		TalentTorokuKoshinBFF response  = service.post(mTalent);
		return ResponseEntity.ok(response);
	}
}