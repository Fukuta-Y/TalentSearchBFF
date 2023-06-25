package com.talent.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.ShukanTalentJohoBFFApi;
import com.model.ShukanTalentJohoBFF;
import com.talent.service.ShukanTalentJohoBFFService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ShukanTalentJohoBFFController implements ShukanTalentJohoBFFApi{

    private final ShukanTalentJohoBFFService service;

	// REVIEW: TARGETという接頭辞はあまり適切ではないかと思います。
	// URL自体がリソースを示しPathに付属するパラメータはそのパラメータと関連していることが明確なため。
	@Override
	public ResponseEntity<List<ShukanTalentJohoBFF>> getShukanTalentJohoBFF(
			@NotNull @Min(199001) @Max(210012) @Valid Integer targetNentsuki,
			@NotNull @Min(1) @Max(5) @Valid Integer targetShu, @Size(max = 30) @Valid String talentName) {
		
		// ShukanTalentJohoSearchBFFServiceより取得
		List<ShukanTalentJohoBFF> response  = service.select(targetNentsuki, targetShu, talentName);
		return ResponseEntity.ok(response);
	}
}