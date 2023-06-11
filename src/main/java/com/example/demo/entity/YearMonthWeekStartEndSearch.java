package com.example.demo.entity;
import java.io.Serializable;

import com.example.demo.dto.NentsukiShuKanriMasterDto;

import lombok.Data;
/**
 * 週間タレント別情報検索レスポンス
 */
@Data
public class YearMonthWeekStartEndSearch implements Serializable {
    private NentsukiShuKanriMasterDto nentsukiShuKanriMasterDto;
}