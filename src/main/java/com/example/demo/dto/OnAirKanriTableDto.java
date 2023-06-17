package com.example.demo.dto;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
/**
 * オンエア管理テーブルDTO
 */
@Data
public class OnAirKanriTableDto implements Serializable {
   private String id;
   private String onairDay;
   private String programId;
   private String talentId;
   private Integer targetNentsuki;
   private Integer targetShu;
   private Integer deleteFlg;
   private Date torokuDay;
   private Date koushinDay;
}
