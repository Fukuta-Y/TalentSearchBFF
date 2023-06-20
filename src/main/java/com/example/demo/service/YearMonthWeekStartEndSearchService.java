package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.NentsukiShuKanriMasterDto;
import com.example.demo.repository.mapper.generated.MNentsukiShuKanriMapper;
import com.example.demo.service.helper.MNentsukiShuKanriHelper;
import com.model.YearMonthWeekStartEndJoho;

import lombok.RequiredArgsConstructor;

/**
 * 年月週の開始終了日付検索 Service
 */
@Service
@RequiredArgsConstructor
public class YearMonthWeekStartEndSearchService {

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