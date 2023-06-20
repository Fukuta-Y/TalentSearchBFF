package com.talent.service.entity;
import java.io.Serializable;
import java.util.List;

import com.talent.dto.OnAirKanriTableDto;
import com.talent.dto.ProgramMasterDto;
import com.talent.dto.TalentMasterDto;

import lombok.Data;
/**
 * 週間タレント別情報エンティティ
 */
@Data
public class ShukanTalentJohoEntity implements Serializable {
    private List<OnAirKanriTableDto> onAirKanriTableDto;
    private List<ProgramMasterDto> programMasterDto;
    private List<TalentMasterDto> talentMasterDto;
}