package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.KbnMasterBFFApi;
import com.model.KbnMasterInfo;
import com.talent.service.KbnMasterBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class KbnMasterBFFController implements KbnMasterBFFApi{
	
	// KbnMasterBFFServiceを宣言
	private final KbnMasterBFFService service;
	
	 /**
	  * 区分マスタBFFController
	  *
	  * @param genreIds ジャンルID
	  * @return KbnMasterInfo
	  * 
	 */
	public ResponseEntity<KbnMasterInfo> getKbnMasterBFF(String genreIds) {
		return ResponseEntity.ok(service.select(genreIds));
	}
}