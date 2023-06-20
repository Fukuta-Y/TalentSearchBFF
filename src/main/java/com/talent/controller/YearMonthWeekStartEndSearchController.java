package com.talent.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.YearMonthWeekStartEndSearchApi;
import com.model.YearMonthWeekStartEndJoho;
import com.talent.service.YearMonthWeekStartEndSearchService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class YearMonthWeekStartEndSearchController implements YearMonthWeekStartEndSearchApi{

    private final YearMonthWeekStartEndSearchService service;
	
	@Override
	public ResponseEntity<YearMonthWeekStartEndJoho> getYearMonthWeekStartEndSearch(
			@NotNull @Min(199001) @Max(210012) @Valid Integer targetNentsuki,
			@NotNull @Min(1) @Max(5) @Valid Integer targetShu) {

		// YearMonthWeekStartEndSearchServiceの取得
		YearMonthWeekStartEndJoho response = service.select(targetNentsuki, targetShu);
		return ResponseEntity.ok(response);
	}
}