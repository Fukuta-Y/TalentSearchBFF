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
	
	// OnAirKanriInfoBFFServiceを宣言
	private final OnAirKanriInfoBFFService service;
	
	/**
	 * オンエア管理情報BFFController
	 *
	 * @param id ID
	 * @return OnAirKanriList
	 * 
	*/
	@Override
	public ResponseEntity<OnAirKanriList> getOnAirKanriInfoBFF(String id) {
		// OnAirKanriInfoBFFServiceより取得
		OnAirKanriList response = service.getOnAirKanriList(id);
		return ResponseEntity.ok(response);
	}

	/**
	 * オンエア管理登録・更新BFFController
	 *
	 * @param tOnAirKanri オンエア管理テーブルDTO
	 * @return OnAirKanriList
	 * 
	*/
	@Override
	public ResponseEntity<OnAirKanriList> postOnAirKanriInfoBFF(TOnAirKanri tOnAirKanri) {
		// OnAirKanriInfoBFFServiceより取得
		OnAirKanriList response  = service.postOnAirKanriList(tOnAirKanri);
		return ResponseEntity.ok(response);
	}
}