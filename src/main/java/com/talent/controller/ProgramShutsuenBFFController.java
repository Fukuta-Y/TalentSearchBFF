package com.talent.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.ProgramShutsuenBFFApi;
import com.model.ProgramShutsuenBFF;
import com.talent.service.ProgramShutsuenBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProgramShutsuenBFFController implements ProgramShutsuenBFFApi{

    private final ProgramShutsuenBFFService service;

	@Override
	public ResponseEntity<List<ProgramShutsuenBFF>> getProgramShutsuenBFF(String programId, String onairDay, Integer nentsuki, Integer shu) {
		// ProgramShutsuenBFFServiceより取得
		List<ProgramShutsuenBFF> response  = service.select(programId, onairDay, nentsuki, shu);
		return ResponseEntity.ok(response);
	}
}