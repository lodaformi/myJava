package com.loda.myDate;

import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println(calendar.get(Calendar.YEAR));
        //月份从0开始
        System.out.println(calendar.get(Calendar.MONTH)+1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
//        System.out.println(calendar.get(Calendar.HOUR));
//        System.out.println(calendar.get(Calendar.MINUTE));
//        System.out.println(calendar.get(Calendar.SECOND));
        System.out.println("-------------");

        //月份从0开始
        calendar.set(2001,6,14);
        System.out.println(calendar.get(Calendar.YEAR));
        //月份从0开始
        System.out.println(calendar.get(Calendar.MONTH)+1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));


        System.out.println("--------------");
        calendar.add(Calendar.DAY_OF_MONTH, -5);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //计算某年的2月有多少天
        calendar.set(2021,2,1); //3月1日
        calendar.add(Calendar.YEAR, 2);
        System.out.println(calendar.get(Calendar.YEAR));
        calendar.add(Calendar.DAY_OF_MONTH,-1);  //往前推一天，就是2月的最后一天
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));



    }
}
