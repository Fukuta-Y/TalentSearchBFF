package com.talent.repository.mapper.generated;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.talent.dto.TalentMasterDto;

@Mapper
public interface MTalentMapper {
    List<TalentMasterDto> select(String talentName);
}