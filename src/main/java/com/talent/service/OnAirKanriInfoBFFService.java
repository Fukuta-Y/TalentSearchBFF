package com.talent.service;

import org.springframework.stereotype.Service;

import com.model.OnAirKanriList;
import com.model.TOnAirKanri;
import com.talent.setting.WebClientInfo;

import lombok.RequiredArgsConstructor;

/**
 * オンエア管理情報BFFService
 */
@Service
@RequiredArgsConstructor
public class OnAirKanriInfoBFFService {

	// WebClientInfoを宣言
    private final WebClientInfo webClient;

    /**
     * オンエア管理情報BFF Service
     *
     * @param id ID
     * @return OnAirKanriList
     */
    public OnAirKanriList getOnAirKanriList(String id) {
    	// (1) パラメータのIDをキーとして、BE「オンエア管理テーブル検索」へ検索して、取得したオンエア管理テーブルDTOをレスポンスへ設定する。
    	OnAirKanriList response = this.webClient.getOnAirKanri(id);
        // Responseへ設定
        return response;
    }
    
    /**
     * オンエア管理登録・更新 Service
     *
     * @param tOnAirKanri オンエア管理テーブルDTO
     * @return OnAirKanriList
     */
    public OnAirKanriList postOnAirKanriList(TOnAirKanri tOnAirKanri) {
    	// (1) BE「オンエア管理登録・更新」を呼び出す。
    	OnAirKanriList response = this.webClient.postOnAirKanri(tOnAirKanri);
        // Responseへ設定
        return response;
    }
}