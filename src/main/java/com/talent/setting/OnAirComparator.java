package com.talent.setting;

import com.talent.service.dto.OnairKanriInfoDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;


public class OnAirComparator implements Comparator<OnairKanriInfoDto> {

    //比較メソッド（データクラスを比較して-1, 0, 1を返すように記述する）
    public int compare(OnairKanriInfoDto data1, OnairKanriInfoDto data2) {

        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = sdFormat.parse(data1.getTvProgram().getOnairDay());
            date2 = sdFormat.parse(data2.getTvProgram().getOnairDay());
        } catch (ParseException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        return date1.compareTo(date2);
    }
}