package com.talent.controller;
<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> 9d3789c (番組参照ダイアログ、タレント参照ダイアログ、オンエア管理参照ダイアログ、年月週管理参照ダイアログ、の自動生成の準備)
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.OnAirKanriRefBFFApi;
<<<<<<< HEAD
import com.model.OnAirKanriList;
import com.talent.service.OnAirKanriRefBFFService;

=======
import com.model.TOnAirKanriInfo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
>>>>>>> 9d3789c (番組参照ダイアログ、タレント参照ダイアログ、オンエア管理参照ダイアログ、年月週管理参照ダイアログ、の自動生成の準備)
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OnAirKanriRefBFFController implements OnAirKanriRefBFFApi{
<<<<<<< HEAD

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
=======
	
	
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
>>>>>>> 9d3789c (番組参照ダイアログ、タレント参照ダイアログ、オンエア管理参照ダイアログ、年月週管理参照ダイアログ、の自動生成の準備)
}