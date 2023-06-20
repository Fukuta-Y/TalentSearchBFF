package com.talent.dto;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
/**
 * 番組マスタDTO
 */
@Data
public class ProgramMasterDto implements Serializable {
   private String programId;
   private String programName;
   private Integer chanelId;
   private Integer genreId;
   private Integer deleteFlg;
   private Date torokuDay;
   private Date koushinDay;
}
