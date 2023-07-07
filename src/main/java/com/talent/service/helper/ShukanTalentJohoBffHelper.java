package com.talent.service.helper;

import com.model.MNentsukiShuKanri;
import com.model.ShukanTalentJohoBFF;
import com.model.TOnAirKanri;
import com.talent.service.dto.OnairKanriInfoDto;
import com.talent.service.dto.TalentInfoDto;
import com.talent.service.dto.TalentOnAirChokinInfoDto;
import com.talent.service.dto.TalentShutsuenHonsuDto;
import com.talent.setting.ConfigMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = ConfigMapper.class)
public interface ShukanTalentJohoBffHelper {

    @Mapping(source = "model.talentId", target = "talent.id")
    @Mapping(source = "talentNm", target = "talent.name")
    @Mapping(source = "model.programId", target = "tvProgram.id")
    @Mapping(source = "programNm", target = "tvProgram.name")
    @Mapping(source = "model.onairDay", target = "tvProgram.onairDay")
    OnairKanriInfoDto toOnairKanriInfoDto(TOnAirKanri model, String talentNm, String programNm);

    TalentShutsuenHonsuDto toTalentShutsuenHonsuDto(OnairKanriInfoDto onairDto);

    @Mapping(source = "count", target = "shukanShutsuenHonsu")
    TalentShutsuenHonsuDto toTalentShutsuenHonsuDto(TalentShutsuenHonsuDto talentDto, Long count);

    @Mapping(source = "talent.id", target = "talent.id")
    @Mapping(source = "talent.name", target = "talent.name")
    @Mapping(source = "tvProgram.id", target = "tvProgram.id")
    @Mapping(source = "tvProgram.name", target = "tvProgram.name")
    @Mapping(source = "tvProgram.onairDay", target = "tvProgram.onairDay")
    TalentOnAirChokinInfoDto toTalentOnairChokinInfoDto(OnairKanriInfoDto dto1);

    @Mapping(source = "talentDto.talent.id", target = "talent.id")
    @Mapping(source = "talentDto.talent.name", target = "talent.name")
    TalentInfoDto toTalentInfoDto(TalentShutsuenHonsuDto talentDto, TalentOnAirChokinInfoDto onairDto);

    @Mapping(source = "talentInfoDto.talent.id", target = "talentId")
    @Mapping(source = "talentInfoDto.talent.name", target = "talentName")
    @Mapping(source = "honsu", target = "shukanShutsuenProgramHonsu")
    @Mapping(source = "talentInfoDto.tvProgram.name", target = "shutsuenProgramChokin")
    @Mapping(source = "talentInfoDto.tvProgram.onairDay", target = "onAirDayChokin")
    @Mapping(source = "netsuki.shuFrom", target = "shuFrom")
    @Mapping(source = "netsuki.shuTo", target = "shuTo")
    ShukanTalentJohoBFF toShukanTalentJohoBFF(TalentInfoDto talentInfoDto, Integer honsu, MNentsukiShuKanri netsuki);

}