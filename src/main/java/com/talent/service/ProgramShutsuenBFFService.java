package com.talent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.ProgramShutsuen;
import com.model.ProgramShutsuenBFF;
import com.model.ProgramShutsuenList;
import com.model.YearMonthWeekStartEndJoho;
import com.talent.setting.WebClientInfo;

import lombok.RequiredArgsConstructor;

/**
 * 番組出演者検索BFF Service
 */
@Service
@RequiredArgsConstructor
public class ProgramShutsuenBFFService {

    private final WebClientInfo webClient;

    /**
     * 番組出演者検索BFF
     *
     * @param programId 番組ID
     * @param onairDay  オンエア日
     * @param nentsuki  年月
     * @param shu     　週
     * @return 検索結果
     */
    public List<ProgramShutsuenBFF> select(String programId, String onairDay, Integer nentsuki, Integer shu) {

    	// reponseを宣言
        List<ProgramShutsuenBFF> response = new ArrayList<ProgramShutsuenBFF>();
    	
		// (1) BE「年月週の開始終了日付検索」より取得
        YearMonthWeekStartEndJoho yearMonthJoho = this.webClient.getYearMonthWeekStartEnd(nentsuki, shu);
    	
		// (2) BE「番組出演者検索」より取得
        ProgramShutsuenList talentJoho = this.webClient.getProgramShutsuen(programId, onairDay);
        for (ProgramShutsuen e : talentJoho.getProgramShutsuen()) {
        	ProgramShutsuenBFF model = new ProgramShutsuenBFF();
			// (1)で取得したレスポンスを以下のように設定する。
			// ・対象週(FROM)へ、年月週管理マスタDTO .週の開始日（日曜日）を設定
			// ・対象週(TO)へ、年月週管理マスタDTO .週の終了日（土曜日）を設定
        	model.setShuFrom(yearMonthJoho.getmNentsukiShuKanri().getShuFrom());
        	model.setShuTo(yearMonthJoho.getmNentsukiShuKanri().getShuTo());
			// (2)で取得したレスポンスを以下のように設定する。
    		// ・タレントID⇒　レスポンス.タレントID
    		// ・タレント名⇒　レスポンス.タレント名
        	model.setTalentId(e.getTalentId());
        	model.setTalentName(e.getTalentName());
	        response.add(model);
        }
        // responseの返却
        return response;
    }
}