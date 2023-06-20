package com.talent.repository.mapper.generated;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.talent.dto.ProgramMasterDto;
@Mapper
public interface MProgramMapper {
	List<ProgramMasterDto> select(List<String> idList);
}