package com.talent.infrastructure.repository.mapper.generated;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.talent.infrastructure.dto.TalentMasterDto;

@Mapper
public interface MTalentMapper {
    List<TalentMasterDto> select(String talentName);
}