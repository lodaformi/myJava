package com.loda.myDate;

import java.time.*;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        System.out.println(Year.now());
        System.out.println(Year.of(2008));


//        System.out.println(Month.NOVEMBER);

        LocalDate ld = LocalDate.now();
        System.out.println(ld);
//        System.out.println(ld.getYear());
//        System.out.println(ld.getMonth());
//        System.out.println(ld.getDayOfMonth());
//        System.out.println(ld.getDayOfWeek());
//        System.out.println(ld.getDayOfYear());

        LocalTime lt = LocalTime.now();
        System.out.println(lt);
//        System.out.println(lt.getHour());
//        System.out.println(lt.getMinute());
//        System.out.println(lt.getSecond());
//        System.out.println(lt.getNano());


        LocalDate bh = LocalDate.of(2000, 8, 27);
        System.out.println(bh);

        LocalDateTime ldt = LocalDateTime.of(2002, 10, 4,13, 45, 55 );
        System.out.println(ldt);
//        LocalDateTime ldt = LocalDateTime.now();
//        System.out.println(ldt.getYear());
//        System.out.println(ldt.getMonth());
//        System.out.println(ldt.getDayOfMonth());
//        System.out.println(ldt.getHour());
//        System.out.println(ldt.getMinute());
//        System.out.println(ldt.getSecond());
//        System.out.println(ldt.getNano());
    }
}
