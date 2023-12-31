package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.ProgramTorokuKoshinBFFApi;
import com.model.MProgram;
import com.model.ProgramTorokuKoshinBFF;
import com.talent.service.ProgramTorokuKoshinBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProgramTorokuKoshinBFFController implements ProgramTorokuKoshinBFFApi{

	// ProgramTorokuKoshinBFFServiceを宣言
	private final ProgramTorokuKoshinBFFService service;

	/**
	 * 番組登録・更新BFFController
	 *
	 * @param mProgram 番組マスタDTO
	 * @return ProgramTorokuKoshinBFF
	 * 
	*/
	@Override
	public ResponseEntity<ProgramTorokuKoshinBFF> postProgramTorokuKoshinBFF(MProgram mProgram) {
		// ProgramTorokuKoshinBFFServiceより取得
		ProgramTorokuKoshinBFF response  = service.postProgramTorokuKoshinBFF(mProgram);
		return ResponseEntity.ok(response);
	}
}