package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.ShukanTalentJohoSearchApi;
import com.example.demo.entity.ShukanTalentJohoSearchEntity;
import com.example.demo.service.ShukanTalentJohoSearchService;
import com.model.ShukanTalentJohoSearch;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Controller
public class ShukanTalentJohoSearchController implements ShukanTalentJohoSearchApi{
	
	@Autowired(required = false)
	public ShukanTalentJohoSearchService service;
	
	//@Autowired(required = false)
	//public ShukanTalentJohoSearchHelper helper;

	@Override
	public ResponseEntity<ShukanTalentJohoSearch> getShukanTalentJohoSearch(
			@NotNull @Min(199001) @Max(210012) @Valid Integer targetNentsuki,
			@NotNull @Min(1) @Max(5) @Valid Integer targetShu, @Size(max = 30) @Valid String talentName) {
		
		ShukanTalentJohoSearch model = new ShukanTalentJohoSearch();
		
		// YearMonthWeekStartEndSearchServiceの取得
		ShukanTalentJohoSearchEntity entity = service.select(targetNentsuki, targetShu, talentName);
		
		// TODO:MapStructの不備
		//model.setmProgram(helper.toProgramModel(entity.getProgramMasterDto()));
		//model.setmTalent(helper.toTalentModel(entity.getTalentMasterDto()));
		//model.settOnAirKanri(helper.toOnAirKanriTableModel(entity.getOnAirKanriTableDto()));
	
		return ResponseEntity.ok(model);
	}
}