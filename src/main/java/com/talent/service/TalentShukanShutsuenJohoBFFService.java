package com.talent.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.model.MChannelKyoku;
import com.model.MKbnGenre;
import com.model.MProgram;
import com.model.MTalent;
import com.model.TOnAirKanri;
import com.model.TalentShukanShutsuen;
import com.model.TalentShukanShutsuenJoho;
import com.model.TalentShukanShutsuenJohoBFF;
import com.model.YearMonthWeekStartEndJoho;
import com.talent.setting.WebClientInfo;

import lombok.RequiredArgsConstructor;

/**
 * タレント週間出演情報検索Service
 */
@Service
@RequiredArgsConstructor
public class TalentShukanShutsuenJohoBFFService {

	// WebClientInfoを宣言
    private final WebClientInfo webClient;

    /**
     * タレント週間出演情報検索Service
     *
     * @param nentsuki  年月
     * @param shu       週
     * @param talentId タレントID
     * @return TalentShukanShutsuenJohoBFF
     */
    public TalentShukanShutsuenJohoBFF getTalentShukanShutsuenJohoBFF(Integer nentsuki, Integer shu, String talentId) {
    	
    	// reponseを宣言
    	TalentShukanShutsuenJohoBFF response = new TalentShukanShutsuenJohoBFF();
    	List<TalentShukanShutsuen> listTalentShukanShutsuen = new ArrayList<TalentShukanShutsuen>();

    	TalentShukanShutsuen bffModel = new TalentShukanShutsuen();
        
        // BE「タレント週間出演情報検索」より取得処理
        TalentShukanShutsuenJoho talentJoho = this.webClient.getTalentShukanShutsuenJoho(nentsuki, shu, talentId);
        // 戻りの内容が設定されていなかった場合
        if (talentJoho.gettOnAirKanri() == null) {
        	return response;
        }
        // 各テーブルごとの内容を取得
        List<TOnAirKanri> onAirList = talentJoho.gettOnAirKanri();
        List<MTalent> mTalentList = talentJoho.getmTalent();
        List<MProgram> mProgramList = talentJoho.getmProgram();
        List<MChannelKyoku> mChannelKyokuList = talentJoho.getmChannelKyoku();
        List<MKbnGenre>  mKbnGenreList = talentJoho.getmKbnGenre();

        // BE「年月週の開始終了日付検索」より取得したレスポンスを以下のように設定する。
        YearMonthWeekStartEndJoho yearMonthJoho = this.webClient.getYearMonthWeekStartEnd(nentsuki, shu);
        
        // レスポンスのオンエア管理テーブルDTOがNULLの場合、(4)の日付設定だけ行う。
        if(onAirList.size() != 0) {
			// 「オンエア管理テーブルDTO」を軸として、キーを突き合わせる。
			// オンエア管理テーブルを繰り返し
			for (TOnAirKanri onAir : onAirList) {
				 // Modelを初期化
				 bffModel = new TalentShukanShutsuen();
				 // 一時保存用の変数を初期化
				 Integer talentGenreId = null;
				 Integer channelId = null;
				 Integer programGenreId = null;
				 Integer channelKyokuId = null;
				 
				 // (1) BE「タレント週間出演情報検索」より取得したレスポンスで以下の条件でデータを絞る。
				 // 取得項目：
				 // オンエア管理テーブルDTO.ID →【レスポンス.ID】
				 bffModel.setId(onAir.getId());
				 // オンエア管理テーブルDTO.オンエア日 → YYYY/MM/DDの形式で【レスポンス.オンエア日】
				 String onAirDayTime = onAir.getOnAirDay().toString();
				 String onAirDay = onAirDayTime.substring(0, 10);
				 bffModel.setOnAirDay(onAirDay);
				
				 // オンエア管理テーブルDTO.オンエア日 →  HH:SSの形式で【レスポンス.放送時間】
				 String onAirTime = onAirDayTime.replace(onAirDay, "").trim();
				 bffModel.setOnAirTime(onAirTime);
	
				// タレントマスタDTOを繰り返し
				for (MTalent talent : mTalentList) {
					// ① オンエア管理テーブルDTO.タレントID =タレントマスタDTO. タレントID
					if(StringUtils.equals(onAir.getTalentId(), talent.getTalentId())) {
						// タレントマスタDTO. タレント名 → 【レスポンス.タレント】
						bffModel.setTalentName(talent.getTalentName());
						// ①を結合時に、タレントマスタDTO. タレント、タレントマスタDTO. ジャンルID、
						talentGenreId = talent.getGenreId();
						break;
					}
				}
				// 番組マスタDTOを繰り返し
				for (MProgram program : mProgramList) {
					//  ② オンエア管理テーブルDTO.番組ID =番組マスタDTO.番組ID
					if(StringUtils.equals(onAir.getProgramId(), program.getProgramId())) {
						// 番組マスタDTO.番組ID → 【レスポンス.番組ID】
						bffModel.setProgramId(program.getProgramId());
						// 番組マスタDTO.番組名 → 【レスポンス.出演番組】
						bffModel.setShutsuenProgram(program.getProgramName());
						// ②を結合時に、番組マスタDTO. 番組名、番組マスタDTO. チャンネルID、番組マスタDTO. ジャンルIDを取得する。
						channelId = program.getChannelId();
						programGenreId = program.getGenreId();
						break;
					}
				}
	       		// チャンネル局マスタDTOを繰り返し
	            // (2) (1)で取得した番組マスタDTO.チェンネルIDを軸として、キーを突き合わせる。
	    		//   取得項目：
	    		//  ・チャンネル局マスタDTO. チャンネル局ID → 【レスポンス.放送局（チャンネル）】
				System.out.println("mChannelKyokuList:" + mChannelKyokuList);
	            for (MChannelKyoku channelKyoku : mChannelKyokuList) {
					// ① 番組マスタDTO.チェンネルID =チャンネル局マスタDTO.チェンネルID 
					if(channelKyoku.getChannelId().compareTo(channelId) == 0 ) {
						// →　①を結合時に、チャンネル局マスタDTO. チャンネル局IDを取得する。
						channelKyokuId = channelKyoku.getChannelKyokuId();
						break;
					}
	            }
	    		// 区分ジャンルマスタDTOを繰り返し
	            for (MKbnGenre kbnGenre :mKbnGenreList) {
	                // (3) (1)で取得したタレントマスタDTO. ジャンルID、番組マスタDTO. ジャンルID、
	                //     (2)で取得したチャンネル局マスタDTO. チャンネル局IDを元に、
	        		//     区分ジャンルマスタDTO.ジャンルIDはそれぞれ固定で、区分ジャンルマスタDTO.順序と結合し、ジャンルを取得する。
	        		//  （①ジャンルID＝１、区分ジャンルマスタDTO.順序 ＝ 番組マスタDTO. ジャンルIDで取得したジャンル
	        		//   →【レスポンス.番組ジャンル】
	            	if(kbnGenre.getGenreId().compareTo(1) == 0 && 
	            			kbnGenre.getJyunjyo().compareTo(programGenreId) == 0) {
	            		bffModel.setProgramGenre(kbnGenre.getGenre());
	            	}
	        		// ②ジャンルID＝２、区分ジャンルマスタDTO.順序 ＝ タレントマスタDTO. ジャンルIDで取得したジャンル
	        		//   →【レスポンス.出演者ジャンル】
	            	if(kbnGenre.getGenreId().compareTo(2) == 0 && 
	            			kbnGenre.getJyunjyo().compareTo(talentGenreId) == 0) {
	            		bffModel.setShutsuenshaGenre(kbnGenre.getGenre());
	            	}
	           		// ③ジャンルID＝３、区分ジャンルマスタDTO.順序 ＝ 番組マスタDTO. チャンネルIDで取得したジャンル
	        		//   →【レスポンス.放送局（チャンネル）】の前半に結合（既にチャンネル局IDが設定済みのため）
		            if(kbnGenre.getGenreId().compareTo(3) == 0 && 
		            		kbnGenre.getJyunjyo().compareTo(programGenreId) == 0) {
		            	String hosokyokuChannel = kbnGenre.getGenre() + "(" + channelKyokuId +")";
	            		bffModel.setHosokyokuChannel(hosokyokuChannel);
	            	}
	            }
	
	    		// 対象週(FROM)へ、年月週管理マスタDTO .週の開始日（日曜日）を設定
	    		// 対象週(TO)へ、年月週管理マスタDTO .週の終了日（土曜日）を設定
	            bffModel.setShuFrom(yearMonthJoho.getmNentsukiShuKanri().getShuFrom());
	            bffModel.setShuTo(yearMonthJoho.getmNentsukiShuKanri().getShuTo());
	            listTalentShukanShutsuen.add(bffModel);
			}
        } else {
			// 対象週(FROM)へ、年月週管理マスタDTO .週の開始日（日曜日）を設定
			// 対象週(TO)へ、年月週管理マスタDTO .週の終了日（土曜日）を設定
	        bffModel.setShuFrom(yearMonthJoho.getmNentsukiShuKanri().getShuFrom());
	        bffModel.setShuTo(yearMonthJoho.getmNentsukiShuKanri().getShuTo());
	        listTalentShukanShutsuen.add(bffModel);
        }
        
        // Responseへ設定
        response.setTalentShukanShutsuen(listTalentShukanShutsuen);
        return response;
    }
}