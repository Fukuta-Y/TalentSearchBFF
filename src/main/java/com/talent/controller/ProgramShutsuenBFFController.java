package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.ProgramShutsuenBFFApi;
import com.model.ProgramShutsuenBFF;
import com.talent.service.ProgramShutsuenBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProgramShutsuenBFFController implements ProgramShutsuenBFFApi{

	// ProgramShutsuenBFFServiceを宣言
    private final ProgramShutsuenBFFService service;
    
    /**
     * 番組出演者検索BFFController
     *
     * @param programId 番組ID
     * @param onAirDay  オンエア日
     * @param nentsuki  年月
     * @param shu     　週
     * @return ProgramShutsuenBFF
     */
	@Override
	public ResponseEntity<ProgramShutsuenBFF> getProgramShutsuenBFF(String programId, String onAirDay, Integer nentsuki, Integer shu) {
		// ProgramShutsuenBFFServiceより取得
		ProgramShutsuenBFF response  = service.getProgramShutsuenBFF(programId, onAirDay, nentsuki, shu);
		return ResponseEntity.ok(response);
	}
}