package com.talent.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.ShukanTalentJohoBFFApi;
import com.model.ShukanTalentJohoBFF;
import com.talent.service.ShukanTalentJohoBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ShukanTalentJohoBFFController implements ShukanTalentJohoBFFApi{

    private final ShukanTalentJohoBFFService service;
	
	@Override
	public ResponseEntity<List<ShukanTalentJohoBFF>> getShukanTalentJohoBFF(Integer targetNentsuki, Integer targetShu, String talentName) {
		// ShukanTalentJohoSearchBFFServiceより取得
		List<ShukanTalentJohoBFF> response  = service.select(targetNentsuki, targetShu, talentName);
		return ResponseEntity.ok(response);
	}
}