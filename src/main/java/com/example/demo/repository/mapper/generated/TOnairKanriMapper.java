package com.example.demo.repository.mapper.generated;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.OnAirKanriTableDto;

@Mapper
public interface TOnairKanriMapper {
	List<OnAirKanriTableDto> select(Integer targetNentsuki, Integer targetShu, List<String> talentIdList);
}