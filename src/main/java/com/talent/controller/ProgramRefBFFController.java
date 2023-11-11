package com.talent.controller;

import com.api.ProgramRefBFFApi;
import com.model.ProgramInfoList;
import com.talent.service.ProgramRefBFFService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ProgramRefBFFController implements ProgramRefBFFApi {

    // ProgramRefBFFServiceを宣言
    private final ProgramRefBFFService service;

    /**
     * 番組参照検索BFFController
     *
     * @param programId   番組ID
     * @param programName 番組名
     * @return ProgramInfoList
     */
    @Override
    public ResponseEntity<ProgramInfoList> getProgramRefBFF(String programId, String programName) {
        // ProgramRefBFFServiceより取得
        ProgramInfoList response = service.getProgramRefBFF(programId, programName);
        return ResponseEntity.ok(response);
    }
}