package com.talent.service.entity;
import lombok.Data;
/**
 * 年月週管理マスタエンティティ
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
