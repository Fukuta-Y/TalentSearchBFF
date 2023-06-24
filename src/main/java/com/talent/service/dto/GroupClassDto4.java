package com.talent.service.dto;
import java.io.Serializable;

import lombok.Data;
/**
 * BFF集約処理4
 */
@Data
public class GroupClassDto4 implements Serializable {
   private String talentId;
   private String talentName;
   private Long shukanShutsuenHonsu;
   private String programName;
   private String onairDay;
}
