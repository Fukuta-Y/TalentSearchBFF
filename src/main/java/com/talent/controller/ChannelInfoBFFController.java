package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.ChannelInfoBFFApi;
import com.model.ChannelInfoList;
import com.talent.service.ChannelInfoBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChannelInfoBFFController implements ChannelInfoBFFApi{
	
	// ChannelInfoBFFServiceを宣言
	private final ChannelInfoBFFService service;

	/**
	 * チャンネル情報BFFController
	 *
	 * @param 無
	 * @return List<ChannelInfo>
	 * 
	*/
	@Override
	public ResponseEntity<ChannelInfoList> getChannelInfoBFF() {
		// ChannelInfoBFFServiceより取得
		ChannelInfoList response  = service.getChannelInfoList();
		return ResponseEntity.ok(response);
	}
}