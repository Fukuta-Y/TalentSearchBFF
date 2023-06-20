package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.ShukanTalentJohoSearchApi;
import com.example.demo.service.ShukanTalentJohoSearchService;
import com.model.ShukanTalentJohoSearch;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ShukanTalentJohoSearchController implements ShukanTalentJohoSearchApi{
	
    private final ShukanTalentJohoSearchService service;

	@Override
	public ResponseEntity<ShukanTalentJohoSearch> getShukanTalentJohoSearch(
			@NotNull @Min(199001) @Max(210012) @Valid Integer targetNentsuki,
			@NotNull @Min(1) @Max(5) @Valid Integer targetShu, @Size(max = 30) @Valid String talentName) {

		// ShukanTalentJohoSearchServiceより取得
		ShukanTalentJohoSearch response = service.select(targetNentsuki, targetShu, talentName);
		return ResponseEntity.ok(response);
	}
}