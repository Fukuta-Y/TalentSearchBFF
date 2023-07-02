package com.talent.service.dto;

import com.talent.service.dto.entity.Talent;
import lombok.Data;

import java.io.Serializable;

/**
 * BFF集約処理2
 */
@Data
public class TalentShutsuenHonsuDto implements Serializable {
    private Talent talent;
    private Long shukanShutsuenHonsu;
    private Integer nentsuki;
    private Integer shu;
}
