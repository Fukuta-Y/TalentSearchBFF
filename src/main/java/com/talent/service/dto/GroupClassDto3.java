package com.talent.service.dto;
import java.io.Serializable;

import com.talent.service.dto.entity.Talent;
import lombok.Data;
import com.talent.service.dto.entity.TvProgram;
/**
 * BFF集約処理3
 */
@Data
public class GroupClassDto3 implements Serializable {
  private Talent talent;
  private TvProgram tvProgram;
}
