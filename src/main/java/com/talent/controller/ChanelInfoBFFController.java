package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.ChanelInfoBFFApi;
import com.model.ChanelInfoList;
import com.talent.service.ChanelInfoBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChanelInfoBFFController implements ChanelInfoBFFApi{
	
	// ChanelInfoBFFServiceを宣言
	private final ChanelInfoBFFService service;

	 /**
	  * チャンネル情報BFFController
	  *
	  * @param 無
	  * @return List<ChanelInfo>
	  * 
	 */
	public ResponseEntity<ChanelInfoList> getChanelInfoBFF() {
		ChanelInfoList response  = service.select();
		return ResponseEntity.ok(response);
	}
}