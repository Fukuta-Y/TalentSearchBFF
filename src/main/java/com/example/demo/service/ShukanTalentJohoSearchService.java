package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.OnAirKanriTableDto;
import com.example.demo.dto.ProgramMasterDto;
import com.example.demo.dto.TalentMasterDto;
import com.example.demo.entity.ShukanTalentJohoSearchEntity;
import com.example.demo.repository.mapper.generated.MProgramMapper;
import com.example.demo.repository.mapper.generated.MTalentMapper;
import com.example.demo.repository.mapper.generated.TOnairKanriMapper;

import lombok.RequiredArgsConstructor;

/**
 * 週間タレント別情報検索 Service
 */
@Service
@RequiredArgsConstructor
public class ShukanTalentJohoSearchService {

    private final MTalentMapper mTalentMapper;
    
    private final TOnairKanriMapper tOnairKanriMapper;
    
    private final MProgramMapper mProgramMapper;

    /**
     * 週間タレント別情報検索
　　　* @param targetNentsuki 対象年月
　　　* @param targetShu 対象週
　　　* @param talentName タレント名
     * @return 検索結果
     */
    public ShukanTalentJohoSearchEntity select(Integer targetNentsuki, Integer targetShu, String talentName) {
    	
    	// 週間タレント別情報検索のresponseを設定
    	ShukanTalentJohoSearchEntity response = new ShukanTalentJohoSearchEntity();
    	
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