package com.talent.setting;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import com.talent.service.dto.OnAirKanriInfoDto;

/**
 * 値の比較用クラス
 */
public class OnAirComparator implements Comparator<OnAirKanriInfoDto> {
    /**
     * オンエア日を取得し、比較して返す
     *
     * @param OnAirKanriInfoDto　data1　オンエア管理情報クラス１
     * @param OnAirKanriInfoDto  data2　オンエア管理情報クラス２
     * @return 比較結果（-1:以下、0:同値、1:以上）
     */
    public int compare(OnAirKanriInfoDto data1, OnAirKanriInfoDto data2) {
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = sdFormat.parse(data1.getTvProgram().getOnAirDay());
            date2 = sdFormat.parse(data2.getTvProgram().getOnAirDay());
        } catch (ParseException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        // 比較して結果を返す
        return date1.compareTo(date2);
    }
}