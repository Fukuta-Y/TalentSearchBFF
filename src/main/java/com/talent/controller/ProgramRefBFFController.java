package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.ProgramRefBFFApi;
import com.model.ProgramInfoRefList;
import com.talent.service.ProgramRefBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProgramRefBFFController implements ProgramRefBFFApi{

	// ProgramRefBFFServiceを宣言
	private final ProgramRefBFFService service;

	/**
	 * 番組参照検索BFFController
	 *
	 * @param programId 番組ID
	 * @param programName 番組名
	 * @return ProgramInfoRefList
	 * 
	*/
	@Override
	public ResponseEntity<ProgramInfoRefList> getProgramRefBFF(String programId, String programName) {
		// ProgramRefBFFServiceより取得
		ProgramInfoRefList response = service.getProgramRefBFF(programId, programName);
		return ResponseEntity.ok(response);
	}
}