package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.setting.WebClientSetting;
import com.model.ShukanTalentJohoSearch;

import lombok.RequiredArgsConstructor;

/**
 * 週間タレント別情報検索 Service
 */
@Service
@RequiredArgsConstructor
public class ShukanTalentJohoSearchBFFService {

    private final WebClientSetting webClient;
    
    /**
     * 週間タレント別情報検索
　　　* @param targetNentsuki 対象年月
　　　* @param targetShu 対象週
　　　* @param talentName タレント名
     * @return 検索結果
     */
    public ShukanTalentJohoSearch select(Integer targetNentsuki, Integer targetShu, String talentName) {
    	
    	// BE「週間タレント別情報検索より取得処理
    	ShukanTalentJohoSearch data = this.webClient.getFirstDataByWebClient(targetNentsuki, targetShu, talentName);
    	
    	// BE「週間タレント別情報検索より取得処理
    	
    	// 【業務処理】

    	// (1) BE「週間タレント別情報検索」より取得したレスポンスで以下の条件でデータを絞る。
    	// （別シート_タレント出演情報検索の結合イメージ　参照）

    	// 【取得条件】
    	// 「オンエア管理テーブルDTO」を軸として、キーを突き合わせる。
    	// ① オンエア管理テーブルDTO.タレントID =タレントマスタDTO. タレントID
    	// ② オンエア管理テーブルDTO.番組ID =番組マスタDTO.番組ID

    	// 上記で突き合わせた場合、タレント名、番号名をレスポンスに設定する。
    	// 突き合わせができなかった、「オンエア管理テーブルDTO」の行については名称系を未設定とする。

    	// (2) 絞った結果をタレントID、タレント名で集約化する。集約時に、タレントID,タレント名、週間出演番組本数のレコードの形にする。
    	// （レスポンスのベース）

    	// (3)　(1)よりタレントIDをキーとして取得して、オンエア日でソートして、最も近いオンエア日の日付の行だけを取得する。
    	// 取得後、タレントID、出演番組（直近）【番組名】、オンエア日（直近）【オンエア日】のレコードの形にする。

    	// (4) (2)に対して、(3)を組み合わせて、レスポンスの形にする。

    	// (5)BE「年月週の開始終了日付検索」より取得したレスポンスを以下のように設定する。
    	// ・対象週(FROM)へ、年月週管理マスタDTO .週の開始日（日曜日）を設定
    	// ・対象週(TO)へ、年月週管理マスタDTO .週の終了日（土曜日）を設定

    	// (6) (4) + (5)を組み合わせて、レスポンスの形にする。
    	
		// dataの返却
        return data;
    }
}