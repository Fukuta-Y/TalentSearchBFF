package com.talent.service.dto;

import java.io.Serializable;

import com.talent.service.dto.entity.Talent;
import com.talent.service.dto.entity.TvProgram;

import lombok.Data;

/**
 * タレント情報DTO
 */
@Data
public class TalentInfoDto implements Serializable {
    private Talent talent;
    private TvProgram tvProgram;
    private Long shukanShutsuenHonsu;
}
