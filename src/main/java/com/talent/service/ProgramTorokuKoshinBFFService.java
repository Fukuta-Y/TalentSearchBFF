package com.talent.service;

import org.springframework.stereotype.Service;

import com.model.MProgram;
import com.model.ProgramTorokuKoshinBFF;
import com.talent.setting.WebClientInfo;

import lombok.RequiredArgsConstructor;

/**
 * 番組登録・更新BFF Service
 */
@Service
@RequiredArgsConstructor
public class ProgramTorokuKoshinBFFService {

	// WebClientInfoを宣言
    private final WebClientInfo webClient;

    /**
     * 番組登録・更新BFF Service
     *
     * @param mProgram　番組マスタDTO
     * @return ProgramTorokuKoshinBFF
     */
    public ProgramTorokuKoshinBFF post(MProgram mProgram) {
    	// (1) BE「番組登録・更新」を呼び出す。
    	ProgramTorokuKoshinBFF response = this.webClient.postProgramTorokuKoshin(mProgram);
        // Responseへ設定
        return response;
    }
}