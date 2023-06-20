package com.talent.entity;
import lombok.Data;
/**
 * 年月週管理マスタDTO
 */
@Data
public class NentsukiShuKanriMasterEntity{
   private Integer nentsuki;
   private Integer shu;
   private String shuFrom;
   private String shuTo;
   private String torokuDay;
   private String koushinDay;
}
