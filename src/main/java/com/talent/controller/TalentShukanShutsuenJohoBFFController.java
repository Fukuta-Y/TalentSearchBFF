package com.talent.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.TalentShukanShutsuenJohoBFFApi;
import com.model.TalentShukanShutsuenJohoBFF;
import com.talent.service.TalentShukanShutsuenJohoBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TalentShukanShutsuenJohoBFFController implements TalentShukanShutsuenJohoBFFApi{
	
    private final TalentShukanShutsuenJohoBFFService service;
	
	@Override
	public ResponseEntity<List<TalentShukanShutsuenJohoBFF>> getTalentShukanShutsuenJohoBFF(Integer nentsuki, Integer shu,String talentId) {
		// TalentShukanShutsuenJohoBFFServiceより取得
		List<TalentShukanShutsuenJohoBFF> response  = service.select(nentsuki, shu, talentId);
		return ResponseEntity.ok(response);
	}
}