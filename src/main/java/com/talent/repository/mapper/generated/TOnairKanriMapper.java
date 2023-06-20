package com.talent.repository.mapper.generated;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.talent.infrastructure.dto.OnAirKanriTableDto;


@Mapper
public interface TOnairKanriMapper {
	List<OnAirKanriTableDto> select(Integer targetNentsuki, Integer targetShu, List<String> talentIdList);
}