package com.example.demo.dto;
import java.io.Serializable;

import lombok.Data;
/**
 * 年月週管理マスタDTO
 */
@Data
public class NentsukiShuKanriMasterDto implements Serializable {
   private Integer nentsuki;
   private Integer shu;
   private String shuFrom;
   private String shuTo;
   private String torokuDay;
   private String koushinDay;
}
