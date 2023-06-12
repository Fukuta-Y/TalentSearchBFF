package com.example.demo.service.helper;

import org.apache.ibatis.annotations.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.dto.NentsukiShuKanriMasterDto;
import com.model.MNentsukiShuKanri;

@Mapper
public interface MNentsukiShuKanriHelper {
	@Mapping(source = "nentsuki", target = "nentsuki")
	MNentsukiShuKanri toModel(NentsukiShuKanriMasterDto model);
 }