package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.controller.helper.ShukanTalentJohoSearchHelper;
import com.example.demo.dto.OnAirKanriTableDto;
import com.example.demo.dto.ProgramMasterDto;
import com.example.demo.dto.TalentMasterDto;
import com.example.demo.entity.ShukanTalentJohoSearchEntity;
import com.example.demo.repository.mapper.generated.MProgramMapper;
import com.example.demo.repository.mapper.generated.MTalentMapper;
import com.example.demo.repository.mapper.generated.TOnairKanriMapper;
import com.model.ShukanTalentJohoSearch;

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
    private final ShukanTalentJohoSearchHelper helper;

    /**
     * 週間タレント別情報検索
　　　* @param targetNentsuki 対象年月
　　　* @param targetShu 対象週
　　　* @param talentName タレント名
     * @return 検索結果
     */
    public ShukanTalentJohoSearch select(Integer targetNentsuki, Integer targetShu, String talentName) {
    	
    	// ShukanTalentJohoSearchEntityを設定
    	ShukanTalentJohoSearchEntity entity = new ShukanTalentJohoSearchEntity();
    	
    	// ShukanTalentJohoSearchをResponseに設定
    	ShukanTalentJohoSearch response = new ShukanTalentJohoSearch();
    	
    	// タレントマスタ検索
		List<TalentMasterDto> talentMasterDto = mTalentMapper.select(talentName);
		List<String> talentIdList = null;
		if (talentMasterDto.size() == 0) entity.setTalentMasterDto(null);
		else {
			talentIdList = new ArrayList<String>();
			//　名称検索の結果のIDをリスト化する
			for(TalentMasterDto dto:talentMasterDto) talentIdList.add(dto.getTalentId());
			entity.setTalentMasterDto(talentMasterDto);
		}

    	// オンエア管理テーブル検索
		List<OnAirKanriTableDto> onAirKanriTableDto = tOnairKanriMapper.select(targetNentsuki, targetShu, talentIdList);
		if (onAirKanriTableDto.size() == 0) {
			entity.setOnAirKanriTableDto(null);
			entity.setTalentMasterDto(null); //　オンエア日がそもそも無かった場合はタレントも空で返す
		} else {
			entity.setOnAirKanriTableDto(onAirKanriTableDto);
		}
		
    	// 番組マスタ検索（オンエア管理テーブル検索が存在する場合のみ実施）
		if (onAirKanriTableDto.size() > 0) {
			List<String> idList = new ArrayList<String>();
			onAirKanriTableDto.forEach(s -> idList.add(s.getProgramId())); 
			List<ProgramMasterDto> programMasterDto = mProgramMapper.select(idList);
			entity.setProgramMasterDto(programMasterDto);
		}
		
		List<ProgramMasterDto>  programDto = entity.getProgramMasterDto();
		response.setmProgram(helper.toProgramModel(programDto));
		
		List<OnAirKanriTableDto>  onairKanriDto = entity.getOnAirKanriTableDto();
		response.settOnAirKanri(helper.toOnAirKanriTableModel(onairKanriDto));

		List<TalentMasterDto>  talnetDto = entity.getTalentMasterDto();
		response.setmTalent(helper.toTalentModel(talnetDto));

		// responseの返却
        return response;
    }
}