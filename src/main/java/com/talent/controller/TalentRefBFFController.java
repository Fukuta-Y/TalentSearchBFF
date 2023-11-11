package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.TalentRefBFFApi;
import com.model.TalentList;
import com.talent.service.TalentRefBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TalentRefBFFController implements TalentRefBFFApi{

	// TalentRefBFFServiceを宣言
	private final TalentRefBFFService service;

	/**
	 * オンエア管理参照検索BFFController
	 *
	 * @param nentsuki 年月
	 * @param shu 週
	 * @return NentsukiShuKanri
	 * 
	*/

	@Override
	public ResponseEntity<TalentList> getTalentRefBFF(String talentId, String talentName) {
		// TalentRefBFFServiceより取得
		TalentList response = service.getTalentRefBFF(talentId, talentName);
		return ResponseEntity.ok(response);
	}}