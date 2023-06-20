package com.talent.service.dto;
import java.io.Serializable;

import lombok.Data;
/**
 * BFF集約処理１
 */
@Data
public class GroupClassDto1 implements Serializable {
   private String id;
   private String onairDay;
   private String talentId;
   private String talentName;
   private String programId;
   private String programName;
   private Integer targetNentsuki;
   private Integer targetShu;
}
