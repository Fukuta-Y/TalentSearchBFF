package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OnAirKanriTableDto;
import com.example.demo.dto.ProgramMasterDto;
import com.example.demo.dto.TalentMasterDto;
import com.example.demo.entity.ShukanTalentJohoSearch;
import com.example.demo.repository.mapper.generated.MProgramMapper;
import com.example.demo.repository.mapper.generated.MTalentMapper;
import com.example.demo.repository.mapper.generated.TOnairKanriMapper;

/**
 * 週間タレント別情報検索 Service
 */
@Service
public class ShukanTalentJohoSearchService {

    @Autowired(required = false)
    public MTalentMapper mTalentMapper;
    
    @Autowired(required = false)
    public TOnairKanriMapper tOnairKanriMapper;
    
    @Autowired(required = false)
    public MProgramMapper mProgramMapper;

    /**
     * 週間タレント別情報検索
　　　* @param targetNentsuki リクエストデータ
　　　* @param targetShu リクエストデータ
　　　* @param talentName リクエストデータ
     * @return 検索結果
     */
    public ShukanTalentJohoSearch select(Integer targetNentsuki, Integer targetShu, String talentName) {
    	
    	// ユーザー情報検索のresponseを設定
		ShukanTalentJohoSearch response = new ShukanTalentJohoSearch();
    	
    	// タレントマスタ検索
		List<TalentMasterDto> talentMasterDto = mTalentMapper.select(talentName);
		response.setTalentMasterDto(talentMasterDto);
    	
    	// オンエア管理テーブル検索
		List<OnAirKanriTableDto> onAirKanriTableDto = tOnairKanriMapper.select(targetNentsuki, targetShu);
		response.setOnAirKanriTableDto(onAirKanriTableDto);

    	// 番組マスタ検索（オンエア管理テーブル検索が存在する場合のみ実施）
		if (onAirKanriTableDto != null) {
			List<String> idList = new ArrayList<String>();
			onAirKanriTableDto.forEach(s -> 
				idList.add(s.getProgramId())
			); 
			List<ProgramMasterDto> programMasterDto = mProgramMapper.select(idList);
			response.setProgramMasterDto(programMasterDto);
		}
		
		// responseの返却
        return response;
    }
}