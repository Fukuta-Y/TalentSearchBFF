package com.talent.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.KbnMasterInfo;
import com.model.MKbnGenre;
import com.talent.setting.WebClientInfo;

import lombok.RequiredArgsConstructor;

/**
 * 区分マスタBFFService
 */
@Service
@RequiredArgsConstructor
public class KbnMasterBFFService {

	// WebClientInfoを宣言
    private final WebClientInfo webClient;

    /**
     * 区分マスタBFFService
     *
     * @param 無
     * @return KbnMasterInfo
     */
    public KbnMasterInfo getKbnMasterInfo(String genreIds) {

    	// Responseを宣言
    	KbnMasterInfo response = new KbnMasterInfo();
    	
    	// (1) BE「区分マスタ検索」に対して、ジャンルIDにはパラメータのジャンルID 【複数】を設定して、区分マスタDTOを取得する。
    	KbnMasterInfo kbnMasterInfo = this.webClient.getKbnMaster(genreIds);
    	List<MKbnGenre> mKbnGenreList = kbnMasterInfo.getmKbnGenre();
    	
    	// (2) (1)で取得した内容をそのままレスポンスに使用する。
    	response.setmKbnGenre(mKbnGenreList);

        // Responseへ設定
        return response;
    }
}