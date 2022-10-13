package com.loda.myDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * @Author loda
 * @Date 2022/10/13 14:19
 * @Version 1.0
 */
public class Review01 {
    public static void main(String[] args) {
        //使用默认时区和区域设置获取日历。
        Calendar calendar = Calendar.getInstance();
        //返回一个 Date对象，表示此 Calendar的时间值，现在的时间
        System.out.println(calendar.getTime());

        //月份从0开始算，2表示3月
        calendar.set(2010, 2, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        calendar.set(2014, 5, 28);
        calendar.add(Calendar.MONTH, 3);
        System.out.println(calendar.get(Calendar.MONTH));
        calendar.add(Calendar.YEAR, -4);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println("-----------");


        LocalTime lt = LocalTime.now();
        System.out.println(lt);
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        System.out.println("-----------");

//        System.out.println(ldt.getYear());
//        System.out.println(ldt.getMonthValue());
//        System.out.println(ldt.getMonth());
//        System.out.println(ldt.getDayOfMonth());
//        System.out.println(ldt.getHour());
//        System.out.println(ldt.getMinute());
//        System.out.println(ldt.getSecond());

        LocalDateTime ldt2 = LocalDateTime.of(2008, 10, 26, 19, 35);
//        System.out.println(ldt2.getYear());
//        System.out.println(ldt2.getMonthValue());
//        System.out.println(ldt2.getDayOfMonth());
//        System.out.println(ldt2.getHour());
//        System.out.println(ldt2.getMinute());
//        System.out.println(ldt2.getSecond());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(ldt2.format(dtf));

        String dateStr = "2016-01-18 20:54:27";
        System.out.println(LocalDateTime.parse(dateStr, dtf));
    }
}
