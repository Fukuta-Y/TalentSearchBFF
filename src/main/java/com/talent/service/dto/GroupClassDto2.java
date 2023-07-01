package com.talent.service.dto;
import java.io.Serializable;
import com.talent.service.dto.entity.Talent;

import lombok.Data;
/**
 * BFF集約処理2
 */
@Data
public class GroupClassDto2 implements Serializable {
   private Talent talent;
   private Long shukanShutsuenHonsu;
   private Integer targetNentsuki;
   private Integer targetShu;
}
