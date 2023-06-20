package com.talent.dto;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
/**
 * タレントマスタDTO
 */
@Data
public class TalentMasterDto implements Serializable {
   private String talentId;
   private String talentName;
   private Integer genreId;
   private Integer deleteFlg;
   private Date torokuDay;
   private Date koushinDay;
}
