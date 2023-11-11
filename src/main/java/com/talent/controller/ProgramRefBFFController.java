package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.ProgramRefBFFApi;
import com.model.ProgramInfoList;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProgramRefBFFController implements ProgramRefBFFApi{@Override
	public ResponseEntity<ProgramInfoList> getProgramRefBFF(@Size(max = 8) @Valid String programId,
			@Size(max = 30) @Valid String programName) {
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