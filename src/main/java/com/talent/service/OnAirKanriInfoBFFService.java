package com.talent.service;

import org.springframework.stereotype.Service;

import com.model.OnAirKanriList;
import com.talent.setting.WebClientInfo;

import lombok.RequiredArgsConstructor;

/**
 * オンエア管理情報BFF Service
 */
@Service
@RequiredArgsConstructor
public class OnAirKanriInfoBFFService {

	// WebClientInfoを宣言
    private final WebClientInfo webClient;

    /**
     * オンエア管理情報BFF Service
     *
     * @param 
     * @return List<ChanelInfo>
     */
    public OnAirKanriList select(String id) {
    	// (1) パラメータのIDをキーとして、BE「オンエア管理テーブル検索」へ検索して、取得したオンエア管理テーブルDTOをレスポンスへ設定する。
    	OnAirKanriList response = this.webClient.getOnAirKanri(id);
        // Responseへ設定
        return response;
    }
}