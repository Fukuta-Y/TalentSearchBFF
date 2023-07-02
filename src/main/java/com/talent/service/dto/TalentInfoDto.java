package com.talent.service.dto;

import com.talent.service.dto.entity.Talent;
import com.talent.service.dto.entity.TvProgram;
import lombok.Data;

import java.io.Serializable;

/**
 * BFF集約処理4
 */
@Data
public class TalentInfoDto implements Serializable {
    private Talent talent;
    private TvProgram tvProgram;
    private Long shukanShutsuenHonsu;
}
