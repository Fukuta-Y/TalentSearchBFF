package com.talent.service;

import java.util.ArrayList;
import java.util.List;

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
     * @param programId 番組ID
     * @return List<ProgramShutsuenBFF>
     */
    public List<ProgramTorokuKoshinBFF> post(MProgram mProgram) {

    	// reponseを宣言
    	List<ProgramTorokuKoshinBFF> response = new ArrayList<ProgramTorokuKoshinBFF>();
    	
    	// (1) BE「番組登録・更新」を呼び出す。
    	System.err.println("実行前");
    	ProgramTorokuKoshinBFF parameter = this.webClient.postProgramTorokuKoshin(mProgram);
    	response.add(parameter);

        // Responseへ設定
        return response;
    }
}