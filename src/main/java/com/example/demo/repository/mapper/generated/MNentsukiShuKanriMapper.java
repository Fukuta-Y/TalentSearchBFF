package com.example.demo.repository.mapper.generated;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.NentsukiShuKanriMasterDto;
@Mapper
public interface MNentsukiShuKanriMapper {
	NentsukiShuKanriMasterDto select(Integer targetNentsuki, Integer targetShu);
}