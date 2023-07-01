package com.talent.service.dto;
import java.io.Serializable;

import lombok.Data;
import com.talent.service.dto.entity.Talent;
import com.talent.service.dto.entity.TvProgram;

/**
 * BFF集約処理１
 */
@Data
public class GroupClassDto1 implements Serializable {
   private String id;
   private Talent talent;
   private TvProgram program;
   private Integer targetNentsuki;
   private Integer targetShu;
}
