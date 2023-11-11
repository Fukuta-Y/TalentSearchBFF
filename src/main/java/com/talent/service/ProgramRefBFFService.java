package com.talent.service;

import org.springframework.stereotype.Service;

import com.model.ProgramInfoList;
import com.talent.setting.WebClientInfo;

import lombok.RequiredArgsConstructor;

/**
 * オンエア管理参照BFF検索Service
 */
@Service
@RequiredArgsConstructor
public class ProgramRefBFFService {

	// WebClientInfoを宣言
    private final WebClientInfo webClient;

    /**
	/**
	 * 番組参照検索BFFService
	 *
	 * @param programId 番組ID
	 * @param programName 番組名
	 * @return ProgramInfoList
	 * 
	*/
    public ProgramInfoList getProgramRefBFF(String programId, String programName) {

    	// responseを宣言
    	ProgramInfoList response = new ProgramInfoList();

    	// (1) BE「番組参照検索」を呼び出す。
    	response = this.webClient.getProgramRef(programId, programName);

    	// responseの返却
        return response;
    }
}
