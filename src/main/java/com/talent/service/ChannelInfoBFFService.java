package com.talent.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.model.ChannelInfo;
import com.model.ChannelInfoList;
import com.model.ChannelKyoku;
import com.model.KbnMasterInfo;
import com.model.MChannelKyoku;
import com.model.MKbnGenre;
import com.talent.setting.WebClientInfo;

import lombok.RequiredArgsConstructor;

/**
 * チャンネル情報BFFService
 */
@Service
@RequiredArgsConstructor
public class ChannelInfoBFFService {

	// WebClientInfoを宣言
    private final WebClientInfo webClient;

    /**
     * チャンネル情報BFFService
     *
     * @param 無
     * @return ChannelInfoList
     */
    public ChannelInfoList getChannelInfoList() {

    	// Responseを宣言
    	ChannelInfoList response = new ChannelInfoList();
    	// Responseに設定するListを宣言
    	List<ChannelInfo> infoList = new ArrayList<ChannelInfo>();
    	
    	// (1) BE「区分マスタ検索」に対して、ジャンルIDにはパラメータのジャンルID=3を設定して、区分マスタDTOを取得する。
    	String genreId = "3";
    	KbnMasterInfo kbnMasterInfo = this.webClient.getKbnMaster(genreId);
    	List<MKbnGenre> mKbnGenreList = kbnMasterInfo.getmKbnGenre();
    	
    	List<String> channelList = new ArrayList<String>();
    	// (2) BE「チャンネル局マスタ検索」のパラメータ「チャンネルID」に対して、(1)で取得した区分マスタDTO.順序を全てパラメータとして 【複数】を設定して、チャンネル局マスタDTOを取得する。
		for (MKbnGenre e : mKbnGenreList) {
			channelList.add(e.getJyunjyo().toString());
		}
		// ジャンルIDを宣言
		String GenreIds = StringUtils.join(channelList, ',');
		ChannelKyoku channelKyoku = this.webClient.getMChannelKyoku(GenreIds);
    	
    	// (3) 以下の内容で(1)で取得できた行数分内容を設定する。
    	//   (2)で取得したチャンネル局マスタDTO.チャンネル局ID ⇒レスポンス.チャンネルID
    	//   (1)で取得した区分マスタDTO.順序に紐づく、ジャンル⇒チャンネル名
		for (MKbnGenre m : mKbnGenreList) {
			ChannelInfo info = new ChannelInfo();
			for (MChannelKyoku n : channelKyoku.getmChannelKyoku()) {
				if(m.getJyunjyo().compareTo(n.getChannelId())== 0 ) {
					info.setChannelId(n.getChannelKyokuId());
				}
			}
			info.setChannelName(m.getGenre());
			infoList.add(info);
		}
        // Responseへ設定
		response.setChannelInfo(infoList);
        return response;
    }
}