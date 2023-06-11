package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.YearMonthWeekStartEndSearchApi;
import com.example.demo.service.YearMonthWeekStartEndSearchService;
import com.model.YearMonthWeekStartEndJoho;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Controller
public class YearMonthWeekStartEndSearchController implements YearMonthWeekStartEndSearchApi{

	@Autowired(required = false)
	public YearMonthWeekStartEndSearchService service;
	
	@Override
	public ResponseEntity<YearMonthWeekStartEndJoho> getYearMonthWeekStartEndSearch(
			@NotNull @Min(199001) @Max(210012) @Valid Integer targetNentsuki,
			@NotNull @Min(1) @Max(5) @Valid Integer targetShu) {

			
		YearMonthWeekStartEndJoho response = new YearMonthWeekStartEndJoho();
				
		com.model.MNentsukiShuKanri model = service.select(targetNentsuki, targetShu);
		model.setNentsuki(model.getNentsuki());
		
		response.setmNentsukiShuKanri(model);
		
		return ResponseEntity.ok(response);
	}

}