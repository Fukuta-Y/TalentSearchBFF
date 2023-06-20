package com.talent.service.entity;
import java.io.Serializable;

import com.talent.service.dto.NentsukiShuKanriMasterDto;

import lombok.Data;
/**
 * 年月週の開始終了日付エンティティ
 */
@Data
public class YearMonthWeekStartEndEntity implements Serializable {
    private NentsukiShuKanriMasterDto nentsukiShuKanriMasterDto;
}