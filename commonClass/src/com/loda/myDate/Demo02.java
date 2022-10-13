package com.loda.myDate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo02 {
    public static void main(String[] args) {
        Date date = new Date();
//    DateFormat df = new SimpleDateFormat()
        Calendar calendar =  Calendar.getInstance();
        System.out.println(calendar);


        // 月份从0开始算
        //快速计算某一年的2月份有多少天，先把日期设置到3月1号，往前推算一天就是2月的最后一天
        calendar.set(2000,2,1);
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        calendar.set(1990,1,1);

    }


}
