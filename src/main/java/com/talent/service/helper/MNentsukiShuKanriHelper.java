package com.talent.service.helper;

import org.mapstruct.Mapper;

import com.model.MNentsukiShuKanri;
import com.talent.service.dto.NentsukiShuKanriMasterDto;
import com.talent.setting.ConfigMapper;

@Mapper(config = ConfigMapper.class)
public interface MNentsukiShuKanriHelper {
	MNentsukiShuKanri toModel(NentsukiShuKanriMasterDto model);
 }