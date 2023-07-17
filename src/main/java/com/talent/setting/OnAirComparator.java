package com.talent.setting;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import com.talent.service.dto.OnAirKanriInfoDto;


public class OnAirComparator implements Comparator<OnAirKanriInfoDto> {

    //比較メソッド（データクラスを比較して-1, 0, 1を返すように記述する）
    public int compare(OnAirKanriInfoDto data1, OnAirKanriInfoDto data2) {
    	System.out.println("aaaa");
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