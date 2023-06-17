package com.example.demo.controller.helper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.dto.OnAirKanriTableDto;
import com.example.demo.dto.ProgramMasterDto;
import com.example.demo.dto.TalentMasterDto;
import com.example.demo.setting.ConfigMapper;
import com.model.MProgram;
import com.model.MTalent;
import com.model.TOnAirKanri;

@Mapper(config = ConfigMapper.class)
public interface ShukanTalentJohoSearchHelper {
	List<TOnAirKanri> toOnAirKanriTableModel(List<OnAirKanriTableDto> model);
	List<MProgram> toProgramModel(List<ProgramMasterDto> model);
	List<MTalent> toTalentModel(List<TalentMasterDto> model);
 }