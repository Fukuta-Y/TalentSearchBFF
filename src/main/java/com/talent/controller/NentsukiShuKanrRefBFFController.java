package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.NentsukiShuKanrRefBFFApi;
import com.model.NentsukiShuKanri;
import com.talent.service.NentsukiShuKanrRefBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class NentsukiShuKanrRefBFFController implements NentsukiShuKanrRefBFFApi{
	
	// NentsukiShuKanrRefBFFServiceを宣言
	private final NentsukiShuKanrRefBFFService service;

	/**
	 * 年月週管理参照検索BFFController
	 *
	 * @param nentsuki 年月
	 * @param shu 週
	 * @return NentsukiShuKanri
	 * 
	*/
	@Override
	public ResponseEntity<NentsukiShuKanri> getNentsukiShuKanrRefBFF(Integer nentsuki, Integer shu) {
		// NentsukiShuKanrRefBFFServiceより取得
		NentsukiShuKanri response = service.getNentsukiShuKanrRefBFF(nentsuki, shu);
		return ResponseEntity.ok(response);
	}

}