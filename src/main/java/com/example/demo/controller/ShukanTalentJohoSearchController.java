package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.ShukanTalentJohoSearchApi;
import com.example.demo.controller.helper.ShukanTalentJohoSearchHelper;
import com.example.demo.dto.OnAirKanriTableDto;
import com.example.demo.dto.ProgramMasterDto;
import com.example.demo.dto.TalentMasterDto;
import com.example.demo.entity.ShukanTalentJohoSearchEntity;
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
    private final ShukanTalentJohoSearchHelper helper;

	@Override
	public ResponseEntity<ShukanTalentJohoSearch> getShukanTalentJohoSearch(
			@NotNull @Min(199001) @Max(210012) @Valid Integer targetNentsuki,
			@NotNull @Min(1) @Max(5) @Valid Integer targetShu, @Size(max = 30) @Valid String talentName) {
		
		ShukanTalentJohoSearch model = new ShukanTalentJohoSearch();
		
		// YearMonthWeekStartEndSearchServiceの取得
		ShukanTalentJohoSearchEntity entity = service.select(targetNentsuki, targetShu, talentName);

		List<ProgramMasterDto>  programDto = entity.getProgramMasterDto();
		model.setmProgram(helper.toProgramModel(programDto));
		
		List<OnAirKanriTableDto>  onairKanriDto = entity.getOnAirKanriTableDto();
		model.settOnAirKanri(helper.toOnAirKanriTableModel(onairKanriDto));

		List<TalentMasterDto>  talnetDto = entity.getTalentMasterDto();
		model.setmTalent(helper.toTalentModel(talnetDto));
		
		return ResponseEntity.ok(model);
	}
}