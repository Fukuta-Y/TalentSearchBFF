package com.talent.setting;


import com.model.ShukanTalentJohoBFF;

import java.util.Comparator;

public class TalentIdComparator implements Comparator<ShukanTalentJohoBFF> {

    @Override
    public int compare(ShukanTalentJohoBFF joho1, ShukanTalentJohoBFF joho2) {

        Integer talentId1 = Integer.parseInt(joho1.getTalentId());
        Integer talentId2 = Integer.parseInt(joho2.getTalentId());

        return talentId1.compareTo(talentId2);
    }
}