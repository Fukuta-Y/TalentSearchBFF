package com.talent.service;

import org.springframework.stereotype.Service;

import com.model.KbnMasterInfos;
import com.model.ProgramInfo;
import com.model.ProgramInfos;
import com.talent.setting.WebClientInfo;

import lombok.RequiredArgsConstructor;

/**
 * 番組出演者検索BFF Service
 */
@Service
@RequiredArgsConstructor
public class ProgramInfoBFFService {

	// WebClientInfoを宣言
    private final WebClientInfo webClient;

    /**
     * 番組情報BFFService
     *
     * @param programId 番組ID
     * @return List<ProgramShutsuenBFF>
     */
    public ProgramInfo select(String programId) {

    	// reponseを宣言
    	ProgramInfo response = new ProgramInfo();

    	// (1) パラメータの番組IDをキーとして、BE「番組マスタ検索」へ検索して、
    	// 取得した番組マスタDTOのうち、レスポンス「番組ID」、「番組名」、「チャンネルID」、「ジャンルID」を設定する。
    	ProgramInfos programInfos = this.webClient.getProgramInfo(programId);
    	
    	response.setProgramId(programInfos.getmProgram().get(0).getProgramId());
    	response.setProgramName(programInfos.getmProgram().get(0).getProgramName());
    	response.setChanelId(programInfos.getmProgram().get(0).getChanelId());
    	response.setGenreId(programInfos.getmProgram().get(0).getGenreId());
    	
    	// (2) BE「区分マスタ検索」に対して、ジャンルIDには「1、3」をパラメータにして、区分マスタDTOを取得する。
    	String genreId = "1,3";

    	KbnMasterInfos kbnMasterInfo = this.webClient.getKbnMaster(genreId);
    	//  TODO
       	response.setGenreId(kbnMasterInfo.getmKbnGenre().get(0).getGenreId());
       	
       	
       	
    	// (3) チャンネル名を取x得
    	//⇒ ジャンルIDには「1」と(1)で取得した「チャンネルID」を順序として、紐づけて、列「ジャンル」を取得して、レスポンス「チャンネル名」へ設定する。

    	// (4) ジャンル名を取得
    	//⇒ジャンルIDには「3」と(1)で取得した「ジャンルID」を順序として、紐づけて、列「ジャンル」を取得して、レスポンス「ジャンル名」へ設定する。


 
    	
    	

    	
        // Responseへ設定
        return response;
    }
}