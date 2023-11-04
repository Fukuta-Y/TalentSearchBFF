package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.ProgramTorokuKoshinBFFApi;
import com.model.MProgram;
import com.model.ProgramTorokuKoshinBFF;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProgramTorokuKoshinBFFController implements ProgramTorokuKoshinBFFApi{@Override
	
	public ResponseEntity<ProgramTorokuKoshinBFF> postProgramTorokuKoshinBFF(@Valid MProgram mprogram) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
//	
//	// ProgramInfoBFFServiceを宣言
//    private final ProgramInfoBFFService service;
//
//	 /**
//	  * 番組情報BFFController
//	  *
//	  * @param programId 番組ID
//	  * @return ProgramInfo
//	  * 
//	 */
//	@Override
//	public ResponseEntity<ProgramInfo> getProgramInfoBFF(String programId) {
//		ProgramInfo response  = service.select(programId);
//		return ResponseEntity.ok(response);
//	}
}