package com.talent.service;

import org.springframework.stereotype.Service;

import com.model.OnAirKanriRefList;
import com.talent.setting.WebClientInfo;

import lombok.RequiredArgsConstructor;

/**
 * オンエア管理参照検索Service
 */
@Service
@RequiredArgsConstructor
public class OnAirKanriRefBFFService {

	// WebClientInfoを宣言
    private final WebClientInfo webClient;

    /**
     * オンエア管理参照検索Service
     *
	 * @param id　ID
	 * @param onAirDay オンエア日
	 * @return OnAirKanriList
     */
    public OnAirKanriRefList getOnAirKanriRefBFF(String id, String onAirDay) {

    	// responseを宣言
    	OnAirKanriRefList response = new OnAirKanriRefList();

    	// (1) BE「オンエア管理参照検索」を呼び出す。
    	response = this.webClient.getOnAirKanriRef(id, onAirDay);

    	// responseの返却
        return response;
    }
}
