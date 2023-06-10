package com.example.demo.repository.mapper.generated;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.TalentMasterDto;

@Mapper
public interface MTalentMapper {
    List<TalentMasterDto> select(String talentName);
}