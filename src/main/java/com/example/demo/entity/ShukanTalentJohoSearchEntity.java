package com.example.demo.entity;
import java.io.Serializable;
import java.util.List;

import com.example.demo.dto.OnAirKanriTableDto;
import com.example.demo.dto.ProgramMasterDto;
import com.example.demo.dto.TalentMasterDto;

import lombok.Data;
/**
 * 週間タレント別情報検索レスポンス
 */
@Data
public class ShukanTalentJohoSearchEntity implements Serializable {
    private List<OnAirKanriTableDto> onAirKanriTableDto;
    private List<ProgramMasterDto> programMasterDto;
    private List<TalentMasterDto> talentMasterDto;
}