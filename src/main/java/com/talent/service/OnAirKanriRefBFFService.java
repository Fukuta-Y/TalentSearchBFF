package com.talent.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.OnAirKanriList;
import com.model.TOnAirKanri;
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
    public OnAirKanriList getOnAirKanriRefBFF(String id, String onAirDay) {

    	// responseを宣言
    	OnAirKanriList response = new OnAirKanriList();

    	// (1) BE「オンエア管理参照検索」を呼び出す。
    	OnAirKanriList onAirKanriList = this.webClient.getOnAirKanriRef(id, onAirDay);
    	List<TOnAirKanri> tOnAirKanriList = onAirKanriList.gettOnAirKanri();
    	
    	// responseへ設定
    	response.settOnAirKanri(tOnAirKanriList);

    	// responseの返却
        return response;
    }
}