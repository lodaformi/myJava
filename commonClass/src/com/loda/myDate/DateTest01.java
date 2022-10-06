package com.loda.myDate;

import java.util.Date;

public class DateTest01 {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        Date date = new Date();
        System.out.println( date);
        System.out.println(date.getTime());

        Date date1 = new Date(1664855145765L);
        System.out.println(date1);
        System.out.println(date1.getTime());

        date1.setTime(0L);
        System.out.println(date1);
    }
}
