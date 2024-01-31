package com.talent.service;

import org.springframework.stereotype.Service;

import com.model.NentsukiShuKanri;
import com.talent.setting.WebClientInfo;

import lombok.RequiredArgsConstructor;

/**
 * 年月週管理参照検索BFFService
 */
@Service
@RequiredArgsConstructor
public class NentsukiShuKanriRefBFFService {

	// WebClientInfoを宣言
    private final WebClientInfo webClient;

	/**
	 * 年月週管理参照検索BFFService
	 *
	 * @param nentsuki 年月
	 * @param shu 週
	 * @return NentsukiShuKanri
	 * 
	*/
    public NentsukiShuKanri getNentsukiShuKanriRefBFF(Integer nentsuki, Integer shu) {

    	// responseを宣言
    	NentsukiShuKanri response = new NentsukiShuKanri();

    	// (1) BE「年月週管理参照検索」を呼び出す。
    	response = this.webClient.getNentsukiShuKanriRef(nentsuki, shu);

    	// responseの返却
        return response;
    }
}
