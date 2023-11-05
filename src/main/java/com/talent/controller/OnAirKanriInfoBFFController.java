package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.OnAirKanriInfoBFFApi;
import com.model.OnAirKanriList;
import com.model.TOnAirKanri;
import com.talent.service.OnAirKanriInfoBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OnAirKanriInfoBFFController implements OnAirKanriInfoBFFApi{
	
	private final OnAirKanriInfoBFFService service;
	
	/**
	 * オンエア管理情報BFFController
	 *
	 * @param String ID
	 * @return OnAirKanriList
	 * 
	*/
	
	@Override
	public ResponseEntity<OnAirKanriList> getOnAirKanriInfoBFF(String id) {
		OnAirKanriList response = service.select(id);
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<OnAirKanriList> postOnAirKanriInfoBFF(TOnAirKanri tonAirKanri) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	

//	// TalentMasterBFFServiceを宣言
//	private final TalentMasterBFFService service;
//	
//	 /**
//	  * タレント情報BFFController
//	  *
//	  * @param talentId タレントID
//	  * @return TalentInfo
//	  * 
//	 */
//	@Override
//	public ResponseEntity<TalentInfo> getTalentInfoBFF(String talentId) {
//		TalentInfo response = service.select(talentId);
//		return ResponseEntity.ok(response);
//	}

}