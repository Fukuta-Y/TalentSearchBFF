package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.OnAirKanriRefBFFApi;
import com.model.OnAirKanriList;
import com.talent.service.OnAirKanriRefBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OnAirKanriRefBFFController implements OnAirKanriRefBFFApi{

	// OnAirKanriRefBFFServiceを宣言
	private final OnAirKanriRefBFFService service;

	/**
	 * オンエア管理参照検索BFFController
	 *
	 * @param id　ID
	 * @param onAirDay オンエア日
	 * 
	*/
	@Override
	public ResponseEntity<OnAirKanriList> getOnAirKanriRefBFF(String id, String onAirDay) {
		// OnAirKanriRefBFFServiceより取得
		OnAirKanriList response = service.getOnAirKanriRefBFF(id, onAirDay);
		return ResponseEntity.ok(response);
	}
}