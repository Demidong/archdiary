package com.dx.demi.archdiary.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by yunlong.su on 2017/3/27.
 */
public class TimeFormatUtils {
    /**
     * 把时间解析成 hh:mm:ss 或者 mm:ss
     *
     * @param duration 时间 毫秒
     */
    @SuppressLint("DefaultLocale")
    public static String formatDuration(int duration) {
        duration /= 1000; // milliseconds into seconds
        int minute = duration / 60;
        int hour = minute / 60;
        minute %= 60;
        int second = duration % 60;
        if (hour != 0)
            return String.format("%2d:%02d:%02d", hour, minute, second);
        else
            return String.format("%02d:%02d", minute, second);
    }


    /**
     * 解析时间 若在一个小时以内，显示"XX分钟以前"；超过一个小时，显示日期加时间"2017-04-21 06:30"
     *
     * @param createTimeMills
     * @return
     */
    public static String timeFormat(long createTimeMills) {
        long currentTimeMillis = System.currentTimeMillis();
        long diffTime = currentTimeMillis - createTimeMills;
        if (diffTime < 60 * 60 * 1000) {
            //小于一个小时
            return String.format("%s分钟前", diffTime / 1000 / 60);
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return sdf.format(new Date(createTimeMills));
        }
    }

    /**
     * 解析时间 显示日期加时间"2017-04-21 06:30"
     *
     * @param createTimeMills
     * @return
     */
    public static String getTime(long createTimeMills) {
        if(createTimeMills == 0){
            return "--";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(new Date(createTimeMills));
    }
    /**
     * 解析时间 显示日期加时间"2017年04月21日"
     *
     * @param createTimeMills
     * @return
     */
    public static String getDay(long createTimeMills) {
        if(createTimeMills == 0){
            return "--";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(new Date(createTimeMills));
    }

    /**
     * 解析时间 显示日期加时间"2017-04-21 06:30" 截取日期21
     *
     * @param createTimeMills
     * @return
     */
    public static String getDayTime(long createTimeMills) {
        String dayTime = getTime(createTimeMills).substring(8, 10);
        return dayTime;
    }

    /**
     * 解析时间 显示日期加时间"2017-04-21 06:30" 截取分秒06:30
     *
     * @param createTimeMills
     * @return
     */
    public static String getMinAndSecTime(long createTimeMills) {
        String minAndSecTime = getTime(createTimeMills);
        return minAndSecTime.substring(11);
    }

    /**
     * 解析时间 显示日期加时间"2017-04-21 06:30" 截取后s = 3月14日 14:25
     *
     * @param createTimeMills
     * @return
     */
    public static String getMonthAndDayAndMinAndSecTime(long createTimeMills) {
        String time = getTime(createTimeMills);
        String monthTime = time.substring(5, 7);
        if (monthTime.contains("0")) {
            monthTime = monthTime.substring(1);
        }
        String dayTime = time.substring(8, 10);
        String minAndSecTime = time.substring(10);
        String s = monthTime + "月" + dayTime + "日" + minAndSecTime;
        return s;
    }

    /**
     * 设置日期
     * @param createTimeMills
     * @return
     */
    public static String formatData(long createTimeMills) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(createTimeMills);
        int year = calendar.get(Calendar.YEAR);
        long currentTimeMillis = System.currentTimeMillis();
        calendar.setTimeInMillis(currentTimeMillis);

        int nowYear = calendar.get(Calendar.YEAR);
        SimpleDateFormat sdf = null;
        if (nowYear != year) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        } else {
            sdf = new SimpleDateFormat("MM-dd HH:mm");
        }

        return sdf.format(new Date(createTimeMills));
    }
    /**
     * 设置日期格式  当天的 ：9：00 昨天的： 昨天9：00， 之前的：2017-12-12 9：00
     * @param createTimeMills
     * @return
     */
    public static String formatDate(long createTimeMills) {
        int a = Integer.valueOf(getDayTime(createTimeMills));
        int b = Integer.valueOf(getDayTime(System.currentTimeMillis()));
        if(Math.abs(a-b)==0){
           return getMinAndSecTime(createTimeMills);
        }else if(Math.abs(a-b)==1){
            return "昨天 "+getMinAndSecTime(createTimeMills);
        }else{
            return getTime(createTimeMills);
        }
    }
}
