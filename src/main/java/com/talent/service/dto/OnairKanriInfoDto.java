package com.talent.service.dto;

import com.talent.service.dto.entity.Talent;
import com.talent.service.dto.entity.TvProgram;
import lombok.Data;

import java.io.Serializable;

/**
 * BFF集約処理１
 */
@Data
public class OnairKanriInfoDto implements Serializable {
    private String id;
    private Talent talent;
    private TvProgram tvProgram;
    private Integer nentsuki;
    private Integer shu;
}
