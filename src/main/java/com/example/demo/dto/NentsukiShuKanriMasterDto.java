package com.example.demo.dto;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
/**
 * 年月週管理マスタDTO
 */
@Data
public class NentsukiShuKanriMasterDto implements Serializable {
   private Integer nentsuki;
   private Integer shu;
   private Date shuFrom;
   private Date shuTo;
   private Date torokuDay;
   private Date koushinDay;
}
