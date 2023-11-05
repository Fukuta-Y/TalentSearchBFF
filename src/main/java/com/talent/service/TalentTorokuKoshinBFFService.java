package com.talent.service;

import org.springframework.stereotype.Service;

import com.model.MTalent;
import com.model.TalentTorokuKoshinBFF;
import com.talent.setting.WebClientInfo;

import lombok.RequiredArgsConstructor;

/**
 * タレント登録・更新BFFService
 */
@Service
@RequiredArgsConstructor
public class TalentTorokuKoshinBFFService {

	// WebClientInfoを宣言
    private final WebClientInfo webClient;

    /**
     * タレント登録・更新BFFService
     *
     * @param mTalent　タレントマスタDTO
     * @return TalentTorokuKoshinBFF
     */
    public TalentTorokuKoshinBFF postTalentTorokuKoshinBFF(MTalent mTalent) {
    	// (1) BE「タレント登録・更新」を呼び出す。
    	TalentTorokuKoshinBFF response = this.webClient.postTalentTorokuKoshin(mTalent);
        // Responseへ設定
        return response;
    }
}