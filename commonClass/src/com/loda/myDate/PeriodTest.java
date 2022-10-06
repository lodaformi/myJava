package com.loda.myDate;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate bh = LocalDate.of(2022,9,10);

        Period p = Period.between(bh, today);
        System.out.println(p.getYears()+"-"+p.getMonths()+"-"+p.getDays());

        LocalDate startDate = LocalDate.of(2008, 8,28);
        LocalDate endDate = LocalDate.of(2009,3,12);
        long between = ChronoUnit.YEARS.between(startDate, endDate);
        System.out.println(between);
        between = ChronoUnit.MONTHS.between(startDate,endDate);
        System.out.println(between);
        between = ChronoUnit.DAYS.between(startDate,endDate);
        System.out.println(between);

        Instant in1 = Instant.now();
        Instant in2 = in1.minus(Duration.ofSeconds(10));
        System.out.println(Duration.between(in1, in2));
        System.out.println(Duration.between(in1, in2).getSeconds());

    }
}
