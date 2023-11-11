package com.talent.service;

import org.springframework.stereotype.Service;

import com.model.TalentList;
import com.talent.setting.WebClientInfo;

import lombok.RequiredArgsConstructor;

/**
 * タレント参照検索BFFService
 */
@Service
@RequiredArgsConstructor
public class TalentRefBFFService {

	// WebClientInfoを宣言
    private final WebClientInfo webClient;

    /**
	/**
	 * タレント参照検索BFFService
	 *
	 * @param talentId タレントID
	 * @param talentName タレント名
	 * @return ProgramInfoList
	 * 
	*/
    public TalentList getTalentRefBFF(String talentId, String talentName) {

    	// responseを宣言
    	TalentList response = new TalentList();

    	// (1) BE「タレント参照検索」を呼び出す。
    	response = this.webClient.getTalentRef(talentId, talentName);

    	// responseの返却
        return response;
    }
}
