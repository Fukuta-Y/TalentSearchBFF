package com.example.demo.setting;

import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@MapperConfig(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface ConfigMapper {
}