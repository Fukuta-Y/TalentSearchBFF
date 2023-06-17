package com.example.demo.service.helper;

import org.mapstruct.Mapper;

import com.example.demo.dto.NentsukiShuKanriMasterDto;
import com.example.demo.setting.ConfigMapper;
import com.model.MNentsukiShuKanri;

@Mapper(config = ConfigMapper.class)
public interface MNentsukiShuKanriHelper {
	MNentsukiShuKanri toModel(NentsukiShuKanriMasterDto model);
 }