package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.NentsukiShuKanriMasterDto;
import com.example.demo.repository.mapper.generated.MNentsukiShuKanriMapper;

/**
 * 年月週の開始終了日付検索 Service
 */
@Service
public class YearMonthWeekStartEndSearchService {

    @Autowired(required = false)
    public MNentsukiShuKanriMapper mNentsukiShuKanriMapper;

    /**
     * 年月週の開始終了日付検索
　　　* @param targetNentsuki 対象年月
　　　* @param targetShu 対象週
     * @return 検索結果
     */
    public com.model.MNentsukiShuKanri select(Integer targetNentsuki, Integer targetShu) {
    	
    	NentsukiShuKanriMasterDto nentsukiShuKanriMasterDto = mNentsukiShuKanriMapper.select(targetNentsuki, targetShu);
    	com.model.MNentsukiShuKanri response = new com.model.MNentsukiShuKanri ();
    	
    	response.setNentsuki(nentsukiShuKanriMasterDto.getNentsuki());
    	response.setShu(nentsukiShuKanriMasterDto.getShu());
    	response.setShuFrom(nentsukiShuKanriMasterDto.getShuFrom().toString());
    	response.setShuTo(nentsukiShuKanriMasterDto.getShuTo().toString());
    	response.setKoushinDay(nentsukiShuKanriMasterDto.getKoushinDay().toString());
    	response.setTorokuDay(nentsukiShuKanriMasterDto.getTorokuDay().toString());
    	
		// responseの返却
        return response;
    }
}