package com.talent.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.model.ChannelKyoku;
import com.model.KbnMasterInfo;
import com.model.MKbnGenre;
import com.model.MProgramList;
import com.model.ProgramInfo;
import com.talent.setting.WebClientInfo;

import lombok.RequiredArgsConstructor;

/**
 * 番組出演者検索BFFService
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
    public ProgramInfo getProgramInfo(String programId) {

    	// reponseを宣言
    	ProgramInfo response = new ProgramInfo();

    	// (1) パラメータの番組IDをキーとして、BE「番組マスタ検索」へ検索して、
    	// 取得した番組マスタDTOのうち、レスポンス「番組ID」、「番組名」、「チャンネルID」、「ジャンルID」を設定する。
    	MProgramList prmList = this.webClient.getProgramInfo(programId);
    	
    	response.setProgramId(prmList.getmProgram().get(0).getProgramId());
    	response.setProgramName(prmList.getmProgram().get(0).getProgramName());
    	response.setGenreId(prmList.getmProgram().get(0).getGenreId());
    	
    	// (2) BE「区分マスタ検索」に対して、ジャンルIDには「1、3」をパラメータにして、区分マスタDTOを取得する。
    	String genreId = "1,3";
    	KbnMasterInfo kbnMasterInfo = this.webClient.getKbnMaster(genreId);
    	List<MKbnGenre> mKbnGenreList = kbnMasterInfo.getmKbnGenre();
    	
        //　区分マスタDTOのリストをチェックする
		for (MKbnGenre e : mKbnGenreList) {
			// (3) ジャンル名を取得
			//⇒　ジャンルIDには「1」と(1)で取得した「ジャンルID」を「順序」として紐づけて、レスポンス「ジャンル名」へ、列「ジャンル」を取得して、設定する。
			if(StringUtils.equals(e.getGenreId().toString(), "1") && e.getJyunjyo().compareTo(prmList.getmProgram().get(0).getGenreId()) == 0 ) {
				// ジャンル名
				response.setGenre(e.getGenre());
			}
			// (4) チャンネル名を取得（チャンネル局IDも取得する）
			//⇒　ジャンルIDには「3」と(1)で取得した「チャンネルID」を「順序」として紐づけて、レスポンス「ジャンル名」へ、列「ジャンル」を取得して、設定する。
			if(StringUtils.equals(e.getGenreId().toString(), "3") && e.getJyunjyo().compareTo(prmList.getmProgram().get(0).getChannelId()) == 0 ) {
				// チャンネル名
				response.setChannelName(e.getGenre());
				//　順序をキーとして、BE「チャンネル局マスタ検索」よりチャンネル局IDを取得する。
				ChannelKyoku channelKyoku = this.webClient.getMChannelKyoku(e.getJyunjyo().toString());
				// チャンネルID
				response.setChannelId(channelKyoku.getmChannelKyoku().get(0).getChannelKyokuId());
			}
		 }

        // Responseへ設定
        return response;
    }
}