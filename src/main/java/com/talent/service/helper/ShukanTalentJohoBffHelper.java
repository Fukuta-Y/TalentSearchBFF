package com.talent.service.helper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.model.MNentsukiShuKanri;
import com.model.ShukanTalentJohoBFF;
import com.model.TOnAirKanri;
import com.talent.service.dto.GroupClassDto1;
import com.talent.service.dto.GroupClassDto2;
import com.talent.service.dto.GroupClassDto3;
import com.talent.service.dto.GroupClassDto4;
import com.talent.setting.ConfigMapper;

@Mapper(config = ConfigMapper.class)
public interface ShukanTalentJohoBffHelper {

	@Mapping(source = "talentNm", target = "talent.name")
	@Mapping(source = "programNm", target = "program.id")
	GroupClassDto1 toDto1(TOnAirKanri model, String talentNm, String programNm);
	
	GroupClassDto2 toDto2(GroupClassDto1 dto1);
	
	@Mapping(source = "count", target = "shukanShutsuenHonsu")
	GroupClassDto2 toHonsuDto2(GroupClassDto2 dto2, Long count);

	GroupClassDto3 toDto3(GroupClassDto1 dto1);
	
	@Mapping(source = "dto2.talent.id", target = "talent.id")
	@Mapping(source = "dto2.talent.name", target = "talent.name")
	GroupClassDto4 toDto4(GroupClassDto2 dto2, GroupClassDto3 dto3);
	
	@Mapping(source = "honsu", target = "shukanShutsuenProgramHonsu")
	@Mapping(source = "dto4.tvProgram.name", target = "shutsuenProgramChokin")
	@Mapping(source = "dto4.tvProgram.onairDay", target = "onAirDayChokin")
	@Mapping(source = "joho.shuFrom", target = "shuFrom")
	@Mapping(source = "joho.shuTo", target = "shuTo")
	ShukanTalentJohoBFF toResponse(GroupClassDto4 dto4, Integer honsu, MNentsukiShuKanri joho);
	
 }