package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.NentsukiShuKanriRefBFFApi;
import com.model.NentsukiShuKanri;
import com.talent.service.NentsukiShuKanriRefBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class NentsukiShuKanrRefBFFController implements NentsukiShuKanriRefBFFApi{
	
	// NentsukiShuKanriRefBFFServiceを宣言
	private final NentsukiShuKanriRefBFFService service;

	/**
	 * 年月週管理参照検索BFFController
	 *
	 * @param nentsuki 年月
	 * @param shu 週
	 * @return NentsukiShuKanri
	 * 
	*/
	@Override
	public ResponseEntity<NentsukiShuKanri> getNentsukiShuKanriRefBFF(Integer nentsuki, Integer shu) {
		// NentsukiShuKanrRefBFFServiceより取得
		NentsukiShuKanri response = service.getNentsukiShuKanriRefBFF(nentsuki, shu);
		return ResponseEntity.ok(response);
	}

}