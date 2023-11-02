package com.talent.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.ChanelInfoBFFApi;
import com.model.ChanelInfo;
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
	  * @param 
	  * @return List<ChanelInfo>
	  * 
	 */
	public ResponseEntity<List<ChanelInfo>> getChanelInfoBFF() {
		List<ChanelInfo> response  = service.select();
		return ResponseEntity.ok(response);
	}
}