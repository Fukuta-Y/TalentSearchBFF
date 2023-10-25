package com.talent.service.dto.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 番組情報DTO
 */
@Data
public class TvProgram implements Serializable {
    private String id;
    private String name;
    private String onAirDay;
}