package com.example.demo.controller.helper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.dto.OnAirKanriTableDto;
import com.example.demo.dto.ProgramMasterDto;
import com.example.demo.dto.TalentMasterDto;
import com.model.MProgram;
import com.model.MTalent;
import com.model.TOnAirKanri;

@Mapper
public interface ShukanTalentJohoSearchHelper {
	@Mapping(source = "id", target = "id")
	List<TOnAirKanri> toOnAirKanriTableModel(List<OnAirKanriTableDto> model);
	@Mapping(source = "programId", target = "programId")
	List<MProgram> toProgramModel(List<ProgramMasterDto> model);
	@Mapping(source = "talentId", target = "talentId")
	List<MTalent> toTalentModel(List<TalentMasterDto> model);
 }