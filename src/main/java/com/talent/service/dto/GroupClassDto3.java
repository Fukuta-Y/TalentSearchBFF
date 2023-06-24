package com.talent.service.dto;
import java.io.Serializable;

import lombok.Data;
/**
 * BFF集約処理3
 */
@Data
public class GroupClassDto3 implements Serializable {
   private String talentId;
   private String talentName;
   private String programName;
   private String onairDay;
}
