package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.ProgramInfoBFFApi;
import com.model.ProgramInfo;
import com.talent.service.ProgramInfoBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProgramInfoBFFController implements ProgramInfoBFFApi{
	
	// ProgramInfoBFFServiceを宣言
    private final ProgramInfoBFFService service;
	
	 /**
	  * 番組情報BFFController
	  *
	  * @param programId 番組ID
	  * @return ProgramInfo
	  * 
	 */
	@Override
	public ResponseEntity<ProgramInfo> getProgramInfoBFF(String programId) {
		// ProgramShutsuenBFFServiceより取得
		ProgramInfo response  = service.select(programId);
		return ResponseEntity.ok(response);
	}

}