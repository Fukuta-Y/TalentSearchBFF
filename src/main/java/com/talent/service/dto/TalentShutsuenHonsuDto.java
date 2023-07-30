package com.talent.service.dto;

import java.io.Serializable;

import com.talent.service.dto.entity.Talent;

import lombok.Data;

/**
 * タレント出演本数DTO
 */
@Data
public class TalentShutsuenHonsuDto implements Serializable {
    private Talent talent;
    private Long shukanShutsuenHonsu;
    private Integer nentsuki;
    private Integer shu;
}
