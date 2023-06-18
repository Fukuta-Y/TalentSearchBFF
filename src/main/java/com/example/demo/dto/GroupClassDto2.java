package com.example.demo.dto;
import java.io.Serializable;

import lombok.Data;
/**
 * BFF集約処理2
 */
@Data
public class GroupClassDto2 implements Serializable {
   private String talentId;
   private String talentName;
   private Long shukanShutsuenHonsu;
   private Integer targetNentsuki;
   private Integer targetShu;
}
