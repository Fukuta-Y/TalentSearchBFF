package com.talent.service.dto;

import java.io.Serializable;
import com.talent.service.dto.entity.Talent;
import com.talent.service.dto.entity.TvProgram;

import lombok.Data;
/**
 * BFF集約処理4
 */
@Data
public class GroupClassDto4 implements Serializable {
   private Talent talent;
   private TvProgram tvProgram;
   private Long shukanShutsuenHonsu;
}
