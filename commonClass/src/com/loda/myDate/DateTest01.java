package com.loda.myDate;

import java.util.Date;

public class DateTest01 {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        Date date = new Date();
        System.out.println( date);

        //返回自此 Date对象表示的1970年1月1日00:00:00 GMT以来的毫秒数。
        System.out.println(date.getTime());

        System.out.println("---------");
        //输入一个long值
        Date date1 = new Date(1664855145765L);
        System.out.println(date1);
        System.out.println(date1.getTime());

        //将此 Date对象设置为表示格林尼治标准时间1970年1月1日00:00:00之后的 time毫秒的时间点。
        date1.setTime(0L);
        System.out.println(date1);
    }
}
