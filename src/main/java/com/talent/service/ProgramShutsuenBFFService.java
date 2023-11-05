package com.talent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.ProgramShutsuen;
import com.model.ProgramShutsuenBFF;
import com.model.ProgramShutsuenList;
import com.talent.setting.WebClientInfo;

import lombok.RequiredArgsConstructor;

/**
 * 番組出演者検索BFFService
 */
@Service
@RequiredArgsConstructor
public class ProgramShutsuenBFFService {

	// WebClientInfoを宣言
    private final WebClientInfo webClient;

    /**
     * 番組出演者検索BFFService
     *
     * @param programId 番組ID
     * @param onairDay  オンエア日
     * @param nentsuki  年月
     * @param shu     　週
     * @return List<ProgramShutsuenBFF>
     */
    public List<ProgramShutsuenBFF> select(String programId, String onairDay, Integer nentsuki, Integer shu) {

    	// reponseを宣言
        List<ProgramShutsuenBFF> response = new ArrayList<ProgramShutsuenBFF>();

		// (1) BE「番組出演者検索」より取得
        ProgramShutsuenList talentJoho = this.webClient.getProgramShutsuen(programId, onairDay);
        for (ProgramShutsuen e : talentJoho.getProgramShutsuen()) {
	    	ProgramShutsuenBFF model = new ProgramShutsuenBFF();
			// (2)で取得したレスポンスを以下のように設定する。
			// ・番組名⇒　レスポンス.番組名
			// ・番組ジャンル名 ⇒　レスポンス.番組ジャンル名 
			// ・タレントID⇒　レスポンス.タレントID
			// ・タレント名⇒　レスポンス.タレント名
	    	model.setProgramName(e.getProgramName());
	    	model.setProgramGenre(e.getProgramGenre());
	    	model.setTalentId(e.getTalentId());
	    	model.setTalentName(e.getTalentName());
	        response.add(model);
        }
        // Responseへ設定
        return response;
    }
}