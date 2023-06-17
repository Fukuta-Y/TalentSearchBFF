package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.ShukanTalentJohoSearchBFFApi;
import com.example.demo.service.ShukanTalentJohoSearchBFFService;
import com.model.ShukanTalentJohoSearchBFF;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ShukanTalentJohoSearchBFFController implements ShukanTalentJohoSearchBFFApi{

    private final ShukanTalentJohoSearchBFFService service;
	
	@Override
	public ResponseEntity<ShukanTalentJohoSearchBFF> getShukanTalentJohoSearchBFF(
			@NotNull @Min(199001) @Max(210012) @Valid Integer targetNentsuki,
			@NotNull @Min(1) @Max(5) @Valid Integer targetShu, @Size(max = 30) @Valid String talentName) {
		
		// ShukanTalentJohoSearchBFFServiceより取得
		ShukanTalentJohoSearchBFF response  = service.select(targetNentsuki, targetShu, talentName);
		
		return ResponseEntity.ok(response);
	}
}