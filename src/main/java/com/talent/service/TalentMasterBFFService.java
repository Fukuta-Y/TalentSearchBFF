package com.talent.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.model.KbnMasterInfo;
import com.model.MKbnGenre;
import com.model.TalentInfo;
import com.model.TalentList;
import com.talent.setting.WebClientInfo;

import lombok.RequiredArgsConstructor;

/**
 * タレント情報BFFService
 */
@Service
@RequiredArgsConstructor
public class TalentMasterBFFService {

	// WebClientInfoを宣言
    private final WebClientInfo webClient;

    /**
     * タレント情報BFFService
     *
     * @param talentId タレントID
     * @return TalentInfo
     */
    public TalentInfo select(String talentId) {

    	// Responseを宣言
    	TalentInfo response = new TalentInfo();

    	// (1) パラメータのタレントIDをキーとして、BE「タレントマスタ検索」へ検索する。
    	TalentList talentList = this.webClient.getTalentMaster(talentId);
    	// 取得したタレントマスタDTOのうち、レスポンス「タレントID」、「タレント名」、「ジャンルID」を設定する。
    	response.setTalentId(talentList.getmTalent().get(0).getTalentId());
    	response.setTalentName(talentList.getmTalent().get(0).getTalentName());
    	response.setGenreId(talentList.getmTalent().get(0).getGenreId());

    	// (2) BE「区分マスタ検索」に対して、ジャンルIDには「2」をパラメータにして、区分マスタDTOを取得する。
    	String genreId = "2";
    	KbnMasterInfo kbnMasterInfo = this.webClient.getKbnMaster(genreId);
    	List<MKbnGenre> mKbnGenreList = kbnMasterInfo.getmKbnGenre();
    	
        //　区分マスタDTOのリストをチェックする
		for (MKbnGenre e : mKbnGenreList) {
			// (3) ジャンル名を取得
			//⇒　ジャンルIDには「2」と(1)で取得した「ジャンルID」を順序として、紐づけて、列「ジャンル」を取得して、レスポンス「ジャンル名」へ設定する。
			if(StringUtils.equals(e.getGenreId().toString(),"2") && e.getJyunjyo().compareTo(talentList.getmTalent().get(0).getGenreId()) == 0 ) {
				// ジャンル名
				response.setGenre(e.getGenre());
			}
		}

        // Responseへ設定
        return response;
    }
}