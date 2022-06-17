package com.huafu.android_study.util;

import android.icu.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

public class DateUtil {
    //获取当前系统时间
    public  static String getNowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date());
    }

}
