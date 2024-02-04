package com.talent.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.model.ChannelKyoku;
import com.model.MChannelKyoku;
import com.model.MProgram;
import com.model.ProgramInfoList;
import com.model.ProgramInfoRef;
import com.model.ProgramInfoRefList;
import com.talent.service.helper.ProgramInfoRefHelper;
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
    
	// ProgramInfoRefHelperを宣言
    private final ProgramInfoRefHelper helper;

    /**
	/**
	 * 番組参照検索BFFService
	 *
	 * @param programId 番組ID
	 * @param programName 番組名
	 * @return ProgramInfoRefList
	 * 
	*/
    public ProgramInfoRefList getProgramRefBFF(String programId, String programName) {

    	// responseを宣言
    	ProgramInfoRefList response = new ProgramInfoRefList();

    	// (1) BE「番組参照検索」を呼び出す。
    	ProgramInfoList programInfo = this.webClient.getProgramRef(programId, programName);
    	
    	// 取得できなかったらそのまま返す
    	if (programInfo.getmProgram().size() == 0) {
    		return response;
    	}

    	// (2) BE「チャンネル局マスタ検索」のパラメータ「チャンネルID」に対して、
    	//     (1)で取得した番組マスタDTO.チャンネルIDを全てパラメータとして 【複数】を設定して、チャンネル局マスタDTOを取得する。
    	List<String> channelList = new ArrayList<String>();
		for (MProgram e : programInfo.getmProgram()) {
		    String channelId = e.getChannelId().toString();
		    // 重複を防ぐためにリストに含まれていない場合のみ追加
		    if (!channelList.contains(channelId)) {
		        channelList.add(channelId);
		    }
		}
		// ジャンルIDを宣言
		String GenreIds = StringUtils.join(channelList, ',');
		ChannelKyoku channelKyoku = this.webClient.getMChannelKyoku(GenreIds);
   
    	// (3) チャンネル局IDを取得
    	// ⇒ (1)で取得した番組マスタDTO.チャンネルID= (2)で取得したチャンネル局マスタDTO.チャンネルIDを紐付けて、チャンネル局マスタDTO.チャンネル局IDを取得して、(1)のDTOの各行とセットでチャンネル局IDを設定する。
		ProgramInfoRef programInfoRef;
		List<ProgramInfoRef> list = new ArrayList<ProgramInfoRef>();
		for (MProgram mp : programInfo.getmProgram()) {
			int channelId = mp.getChannelId();
			for (MChannelKyoku ck : channelKyoku.getmChannelKyoku()) {
				if(channelId == ck.getChannelId()) {
					programInfoRef = helper.toProgramInfoRef(mp);
					programInfoRef.setChannelKyokuId(ck.getChannelKyokuId());
					list.add(programInfoRef);
					break;
				}
			}
    	}
    	// responseの返却
		response.setProgramInfoRef(list);
        return response;
    }
}
