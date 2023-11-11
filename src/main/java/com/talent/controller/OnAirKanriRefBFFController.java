package com.talent.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.OnAirKanriRefBFFApi;
import com.model.TOnAirKanriInfo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OnAirKanriRefBFFController implements OnAirKanriRefBFFApi{
	
	
	@Override
	public ResponseEntity<List<TOnAirKanriInfo>> getOnAirKanriRefBFF(@String id, String onAirDay) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

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
}