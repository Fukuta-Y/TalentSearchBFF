package com.example.demo.dto;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
/**
 * チャンネル局マスタDTO
 */
@Data
public class ChanelKyokuMasterDto implements Serializable {
   private Integer chanelId;
   private Integer chanelKyokuId;
   private Integer areaId;
   private Integer deleteFlg;
   private Date torokuDay;
   private Date koushinDay;
}
