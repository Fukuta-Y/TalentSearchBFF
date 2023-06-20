package com.talent.service;

import org.springframework.stereotype.Service;

import com.model.YearMonthWeekStartEndJoho;
import com.talent.repository.mapper.generated.MNentsukiShuKanriMapper;
import com.talent.service.dto.NentsukiShuKanriMasterDto;
import com.talent.service.helper.MNentsukiShuKanriHelper;

import lombok.RequiredArgsConstructor;

/**
 * 年月週の開始終了日付検索 Service
 */
@Service
@RequiredArgsConstructor
public class YearMonthWeekStartEndService {

    private final MNentsukiShuKanriMapper mapper;
    private final MNentsukiShuKanriHelper helper;

    /**
     * 年月週の開始終了日付検索
　　　* @param targetNentsuki 対象年月
　　　* @param targetShu 対象週
     * @return 検索結果
     */
    public YearMonthWeekStartEndJoho select(Integer targetNentsuki, Integer targetShu) {
 
    	// YearMonthWeekStartEndJohoをResponseに設定
    	YearMonthWeekStartEndJoho response = new YearMonthWeekStartEndJoho();

    	// 年月週の開始終了日付検索
    	NentsukiShuKanriMasterDto dto = mapper.select(targetNentsuki, targetShu);

    	// 戻りの内容を設定
    	response.setmNentsukiShuKanri(helper.toModel(dto));
    	
		// responseの返却
        return response;
    }
}