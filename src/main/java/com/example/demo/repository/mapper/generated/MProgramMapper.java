package com.example.demo.repository.mapper.generated;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.ProgramMasterDto;
@Mapper
public interface MProgramMapper {
	List<ProgramMasterDto> select(List<String> idList);
}