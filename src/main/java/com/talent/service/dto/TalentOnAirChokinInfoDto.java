package com.talent.service.dto;

import java.io.Serializable;

import com.talent.service.dto.entity.Talent;
import com.talent.service.dto.entity.TvProgram;

import lombok.Data;

/**
 * タレント・番組DTO
 */
@Data
public class TalentOnAirChokinInfoDto implements Serializable {
    private Talent talent;
    private TvProgram tvProgram;
}
