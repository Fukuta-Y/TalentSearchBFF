package com.talent.setting;


import java.util.Comparator;

import com.model.ShukanTalent;

public class TalentIdComparator implements Comparator<ShukanTalent> {

    /**
     * タレントIDを取得し、比較して返す
     *
     * @param ShukanTalent　週間タレント情報BFF内のリストの戻りModel１
     * @param ShukanTalent　週間タレント情報BFF内のリストの戻りModel２
     * @return 比較結果（-1:以下、0:同値、1:以上）
     */
    @Override
    public int compare(ShukanTalent joho1, ShukanTalent joho2) {

    	// 週間タレント情報BFFの戻りModelより、タレントIDを取得
        Integer talentId1 = Integer.parseInt(joho1.getTalentId());
        Integer talentId2 = Integer.parseInt(joho2.getTalentId());

        // 比較して結果を返す
        return talentId1.compareTo(talentId2);
    }
}