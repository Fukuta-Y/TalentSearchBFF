package com.example.demo.entity;
import java.io.Serializable;

import com.example.demo.dto.NentsukiShuKanriMasterDto;

import lombok.Data;
/**
 * 年月週の開始終了日付検索レスポンス
 */
@Data
public class YearMonthWeekStartEndSearch implements Serializable {
    private NentsukiShuKanriMasterDto nentsukiShuKanriMasterDto;
}