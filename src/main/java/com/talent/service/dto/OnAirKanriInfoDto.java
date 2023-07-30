package com.talent.service.dto;

import java.io.Serializable;

import com.talent.service.dto.entity.Talent;
import com.talent.service.dto.entity.TvProgram;

import lombok.Data;

/**
 * オンエア管理情報DTO
 */
@Data
public class OnAirKanriInfoDto implements Serializable {
    private String id;
    private Talent talent;
    private TvProgram tvProgram;
    private Integer nentsuki;
    private Integer shu;
}
