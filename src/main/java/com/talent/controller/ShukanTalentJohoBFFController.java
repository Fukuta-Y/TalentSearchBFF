package com.talent.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.api.ShukanTalentJohoBFFApi;
import com.model.ShukanTalentJohoBFF;
import com.talent.service.ShukanTalentJohoBFFService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ShukanTalentJohoBFFController implements ShukanTalentJohoBFFApi{

	// ShukanTalentJohoBFFServiceを宣言
    private final ShukanTalentJohoBFFService service;

    /**
     * 週間タレント別情報検索Controller
     *
     * @param nentsuki   年月
     * @param shu        週
     * @param talentName タレント名
     * @return ShukanTalentJohoBFF
     */
	@Override
	public ResponseEntity<ShukanTalentJohoBFF> getShukanTalentJohoBFF(Integer nentsuki, Integer shu, String talentName) {
		// ShukanTalentJohoBFFServiceより取得
		ShukanTalentJohoBFF response  = service.getShukanTalentJohoBFF(nentsuki, shu, talentName);
		return ResponseEntity.ok(response);
	}
}