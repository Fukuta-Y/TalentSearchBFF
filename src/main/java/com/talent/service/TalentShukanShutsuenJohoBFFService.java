package com.talent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.TalentShukanShutsuenJoho;
import com.model.TalentShukanShutsuenJohoBFF;
import com.talent.setting.WebClientInfo;

import lombok.RequiredArgsConstructor;

/**
 * タレント週間出演情報検索 Service
 */
@Service
@RequiredArgsConstructor
public class TalentShukanShutsuenJohoBFFService {

    private final WebClientInfo webClient;

    /**
     * 週間タレント別情報検索
     *
     * @param nentsuki   対象年月
     * @param shu        対象週
     * @param talentName タレント名
     * @return 検索結果
     */
    public List<TalentShukanShutsuenJohoBFF> select(Integer nentsuki, Integer shu, String talentId) {

        List<TalentShukanShutsuenJohoBFF> response = new ArrayList<TalentShukanShutsuenJohoBFF>();
        TalentShukanShutsuenJohoBFF bffModel = new TalentShukanShutsuenJohoBFF();

        // BE「タレント週間出演情報検索」より取得処理
        TalentShukanShutsuenJoho talentJoho = this.webClient.getTalentShukanShutsuenJoho(nentsuki, shu, talentId);

//        ※レスポンスのオンエア管理テーブルDTOがNULLの場合、(4)の日付設定だけ行う。
//        (1) BE「タレント週間出演情報検索」より取得したレスポンスで以下の条件でデータを絞る。
//        取得項目：
//        ・オンエア管理テーブルDTO.オンエア日、
//        　→ YYYY/MM/DDの形式で【レスポンス.オンエア日】
//        　→ HH:SSの形式で【レスポンス.放送時間】
//        ・タレントマスタDTO. タレント名、
//        　→ 【レスポンス.タレント】
//        ・番組マスタDTO.番組名
//        　→ 【レスポンス.出演番組】
//        以下は後続の結合キーとして使用するため取得
//        ・オンエア管理テーブルDTO.番組ID、
//        ・オンエア管理テーブルDTO.タレントID、
//        ・タレントマスタDTO. ジャンルID
//        ・番組マスタDTO. チャンネルID、
//        ・番組マスタDTO. ジャンルID
//
//         【結合条件】
//         「オンエア管理テーブルDTO」を軸として、キーを突き合わせる。
//          ① オンエア管理テーブルDTO.タレントID =タレントマスタDTO. タレントID
//          ② オンエア管理テーブルDTO.番組ID =番組マスタDTO.番組ID
//
//         ①を結合時に、タレントマスタDTO. タレント、タレントマスタDTO. ジャンルID、
//         ②を結合時に、番組マスタDTO. 番組名、番組マスタDTO. チャンネルID、番組マスタDTO. ジャンルIDを取得する。
//
//        (2)  (1)で取得した番組マスタDTO.チェンネルIDを軸として、キーを突き合わせる。
//        取得項目：
//        ・チャンネル局マスタDTO. チャンネル局ID
//        → 【レスポンス.放送局（チャンネル）】
//
//          ① 番組マスタDTO.チェンネルID =チャンネル局マスタDTO.チェンネルID 
//         →　①を結合時に、チャンネル局マスタDTO. チャンネル局IDを取得する。
//
//        (3) (1)で取得したタレントマスタDTO. ジャンルID、番組マスタDTO. ジャンルID、
//        　  (2)で取得したチャンネル局マスタDTO. チャンネル局IDを元に、
//             区分ジャンルマスタDTO.ジャンルIDはそれぞれ固定で、区分ジャンルマスタDTO.順序と結合し、
//             ジャンルを取得する。
//        （　①ジャンルID＝１、区分ジャンルマスタDTO.順序 ＝ 番組マスタDTO. ジャンルIDで取得したジャンル
//        　　→【レスポンス.番組ジャンル】
//        　　②ジャンルID＝２、区分ジャンルマスタDTO.順序 ＝ タレントマスタDTO. ジャンルIDで取得したジャンル
//        　　→【レスポンス.出演者ジャンル】
//        　　③ジャンルID＝３、区分ジャンルマスタDTO.順序 ＝ 番組マスタDTO. チャンネルIDで取得したジャンル
//        　　→【レスポンス.放送局（チャンネル）】の前半に結合（既にチャンネル局IDが設定済みのため）
//        　）
//
//        (4)BE「年月週の開始終了日付検索」より取得したレスポンスを以下のように設定する。
//        ・対象週(FROM)へ、年月週管理マスタDTO .週の開始日（日曜日）を設定
//        ・対象週(TO)へ、年月週管理マスタDTO .週の終了日（土曜日）を設定

        bffModel.setTalentName("");
        bffModel.setShutsuenshaGenre("");
        bffModel.setProgramId("");
        bffModel.setHosokyokuChannel(null);
        bffModel.setShutsuenProgram("");
        bffModel.setOnAirDay("");
        bffModel.setOnAirTime(null);
        bffModel.setProgramGenre("");
        bffModel.setShuFrom("");
        bffModel.setShuTo("");
        
        response.add(bffModel);

        // responseの返却
        return response;
    }
}