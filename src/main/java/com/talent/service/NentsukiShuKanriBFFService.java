package com.talent.service;

import org.springframework.stereotype.Service;

import com.model.MNentsukiShuKanri;
import com.model.NentsukiShuKanri;
import com.talent.setting.WebClientInfo;

import lombok.RequiredArgsConstructor;

/**
 * 年月週管理登録・更新BFFService
 */
@Service
@RequiredArgsConstructor
public class NentsukiShuKanriBFFService {

	// WebClientInfoを宣言
    private final WebClientInfo webClient;

    /**
     * 年月週管理登録・更新BFFService
     *
     * @param MNentsukiShuKanri　年月週管理マスタDTO
     * @return NentsukiShuKanri
     */
    public NentsukiShuKanri postNentsukiShuKanriBFF(MNentsukiShuKanri mNentsukiShuKanri) {
    	// (1) BE「年月週管理登録・更新」を呼び出す。
    	NentsukiShuKanri response = this.webClient.postNentsukiShuKanri(mNentsukiShuKanri);
        // Responseへ設定
        return response;
    }
    
    /**
     * 年月週管理マスタ検索BFFService
     *
     * @param　無
     * @return NentsukiShuKanriBFF
     */
    public NentsukiShuKanri getNentsukiShuKanriBFF() {
    	// (1) BE「年月週管理登録・更新」を呼び出す。
    	NentsukiShuKanri response = this.webClient.getNentsukiShuKanri();
        // Responseへ設定
        return response;
    }
}