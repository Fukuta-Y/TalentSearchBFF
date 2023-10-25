package com.talent.service.helper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.model.MNentsukiShuKanri;
import com.model.ShukanTalentJohoBFF;
import com.model.TOnAirKanri;
import com.talent.service.dto.OnAirKanriInfoDto;
import com.talent.service.dto.TalentInfoDto;
import com.talent.service.dto.TalentOnAirChokinInfoDto;
import com.talent.service.dto.TalentShutsuenHonsuDto;
import com.talent.setting.ConfigMapper;

@Mapper(config = ConfigMapper.class)
public interface ShukanTalentJohoBffHelper {

    @Mapping(source = "model.talentId", target = "talent.id")
    @Mapping(source = "talentNm", target = "talent.name")
    @Mapping(source = "model.programId", target = "tvProgram.id")
    @Mapping(source = "programNm", target = "tvProgram.name")
    @Mapping(source = "model.onAirDay", target = "tvProgram.onAirDay")
    OnAirKanriInfoDto toOnairKanriInfoDto(TOnAirKanri model, String talentNm, String programNm);

    TalentShutsuenHonsuDto toTalentShutsuenHonsuDto(OnAirKanriInfoDto onairDto);

    @Mapping(source = "count", target = "shukanShutsuenHonsu")
    TalentShutsuenHonsuDto toTalentShutsuenHonsuDto(TalentShutsuenHonsuDto talentDto, Long count);

    @Mapping(source = "talent.id", target = "talent.id")
    @Mapping(source = "talent.name", target = "talent.name")
    @Mapping(source = "tvProgram.id", target = "tvProgram.id")
    @Mapping(source = "tvProgram.name", target = "tvProgram.name")
    @Mapping(source = "tvProgram.onAirDay", target = "tvProgram.onAirDay")
    TalentOnAirChokinInfoDto toTalentOnairChokinInfoDto(OnAirKanriInfoDto dto1);

    @Mapping(source = "talentDto.talent.id", target = "talent.id")
    @Mapping(source = "talentDto.talent.name", target = "talent.name")
    TalentInfoDto toTalentInfoDto(TalentShutsuenHonsuDto talentDto, TalentOnAirChokinInfoDto onairDto);

    @Mapping(source = "talentInfoDto.talent.id", target = "talentId")
    @Mapping(source = "talentInfoDto.talent.name", target = "talentName")
    @Mapping(source = "honsu", target = "shukanShutsuenProgramHonsu")
    @Mapping(source = "talentInfoDto.tvProgram.name", target = "shutsuenProgramChokin")
    @Mapping(source = "talentInfoDto.tvProgram.onAirDay", target = "onAirDayChokin")
    @Mapping(source = "netsuki.items.shuFrom", target = "shuFrom")
    @Mapping(source = "netsuki.items.shuTo", target = "shuTo")
    ShukanTalentJohoBFF toShukanTalentJohoBFF(TalentInfoDto talentInfoDto, Integer honsu, MNentsukiShuKanri netsuki);

}