package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.ShukanTalentJohoSearchBFFApi;
import com.model.ShukanTalentJohoSearchBFF;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Controller
public class ShukanTalentJohoSearchBFFController implements ShukanTalentJohoSearchBFFApi{

	@Override
	public ResponseEntity<ShukanTalentJohoSearchBFF> getShukanTalentJohoSearchBFF(
			@NotNull @Min(199001) @Max(210012) @Valid Integer targetNentsuki,
			@NotNull @Min(1) @Max(5) @Valid Integer targetShu, @Size(max = 30) @Valid String talentName) {
		
		ShukanTalentJohoSearchBFF model = new ShukanTalentJohoSearchBFF();

		model.setTalentId("");
		model.setTalentName("");
		model.setShukanShutsuenProgramHonsu(1);
		model.setShutsuenProgramChokin("dd");
		model.setOnAirDayChokin("");
		model.setShuFrom("");
		model.setShuTo("");

		return ResponseEntity.ok(model);
	}
	
}