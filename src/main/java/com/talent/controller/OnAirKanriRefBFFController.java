package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.OnAirKanriRefBFFApi;
import com.model.OnAirKanriList;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OnAirKanriRefBFFController implements OnAirKanriRefBFFApi{
	
	

//	// KbnMasterBFFServiceを宣言
//	private final KbnMasterBFFService service;
//	
//	/**
//	 * 区分マスタBFFController
//	 *
//	 * @param genreIds ジャンルID
//	 * @return KbnMasterInfo
//	 * 
//	*/
//	@Override
//	public ResponseEntity<KbnMasterInfo> getKbnMasterBFF(String genreIds) {
//		// KbnMasterBFFServiceより取得
//		KbnMasterInfo response = service.getKbnMasterInfo(genreIds);
//		return ResponseEntity.ok(response);
//	}


	@Override
	public ResponseEntity<OnAirKanriList> getOnAirKanriRefBFF(@Size(max = 8) @Valid String id, @Valid String onAirDay) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}}