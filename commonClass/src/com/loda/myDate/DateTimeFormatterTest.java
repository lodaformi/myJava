package com.loda.myDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterTest {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        String nowStr = ldt.format(formatter);
        System.out.println(nowStr);



        String dateStr = "2008-10-01 12:32:48";

        LocalDateTime date = LocalDateTime.parse(dateStr, formatter);
        System.out.println(date);
    }
}
