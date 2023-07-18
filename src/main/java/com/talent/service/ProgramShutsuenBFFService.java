package com.talent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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

		// (1) BE「番組出演者検索」より取得したレスポンスを以下のように設定する。
		// ・タレントID⇒　レスポンス.タレントID
		// ・タレント名⇒　レスポンス.タレント名

        List<ProgramShutsuenBFF> response = new ArrayList<ProgramShutsuenBFF>();
        ProgramShutsuenBFF bffModel = new ProgramShutsuenBFF();
        
        // BE「週間タレント別情報検索より取得処理
        ProgramShutsuenList talentJoho = this.webClient.getProgramShutsuen(programId, onairDay);
        
        bffModel.setTalentId(talentJoho.getProgramShutsuen().get(0).getTalentId());
        bffModel.setTalentName(talentJoho.getProgramShutsuen().get(0).getTalentName());
        
		// (2) BE「年月週の開始終了日付検索」より取得したレスポンスを以下のように設定する。
		// ・対象週(FROM)へ、年月週管理マスタDTO .週の開始日（日曜日）を設定
		// ・対象週(TO)へ、年月週管理マスタDTO .週の終了日（土曜日）を設定
        YearMonthWeekStartEndJoho yearMonthJoho = this.webClient.getYearMonthWeekStartEnd(nentsuki, shu);
        bffModel.setShuFrom(yearMonthJoho.getmNentsukiShuKanri().getShuFrom());
        bffModel.setShuTo(yearMonthJoho.getmNentsukiShuKanri().getShuTo());

        response.add(bffModel);
        
        // responseの返却
        return response;
    }
}