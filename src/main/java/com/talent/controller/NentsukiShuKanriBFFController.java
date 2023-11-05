package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.NentsukiShuKanriBFFApi;
import com.model.MNentsukiShuKanri;
import com.model.NentsukiShuKanriBFF;
import com.talent.service.NentsukiShuKanriBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class NentsukiShuKanriBFFController implements NentsukiShuKanriBFFApi{
	
	// NentsukiShuKanriBFFServiceを宣言
	private final NentsukiShuKanriBFFService service;
	
	/**
	 * 年月週管理登録・更新BFFController
	 *
	 * @param mNentsukiShuKanri 年月週管理マスタDTO
	 * @return NentsukiShuKanriBFF
	 * 
	*/
	@Override
	public ResponseEntity<NentsukiShuKanriBFF> postProgramTorokuKoshinBFF(MNentsukiShuKanri mNentsukiShuKanri) {
		// NentsukiShuKanriBFFServiceより取得
		NentsukiShuKanriBFF response = service.postNentsukiShuKanriBFF(mNentsukiShuKanri);
		return ResponseEntity.ok(response);
	}

	/**
	 * 年月週管理マスタ検索BFFController
	 *
	 * @param 
	 * @return NentsukiShuKanriBFF
	 * 
	*/
	@Override
	public ResponseEntity<NentsukiShuKanriBFF> getNentsukiShuKanriBFF() {
		// NentsukiShuKanriBFFServiceより取得
		NentsukiShuKanriBFF response = service.getNentsukiShuKanriBFF();
		return ResponseEntity.ok(response);
	}
}