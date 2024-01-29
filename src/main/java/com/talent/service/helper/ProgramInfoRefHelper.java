package com.talent.service.helper;

import org.mapstruct.Mapper;

import com.model.MProgram;
import com.model.ProgramInfoRef;
import com.talent.setting.ConfigMapper;

@Mapper(config = ConfigMapper.class)
public interface ProgramInfoRefHelper {
    ProgramInfoRef toProgramInfoRef(MProgram mp);

}