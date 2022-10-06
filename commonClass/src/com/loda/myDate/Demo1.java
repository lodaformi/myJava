package com.loda.myDate;

import java.util.Date;

public class Demo1 {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(d1);
        long ms = d1.getTime();

        System.out.println(ms);

        Date d2 = new Date(ms);
        System.out.println(d2);

        System.out.println(d1 ==  d2);
        System.out.println(d1.equals(d2));
    }
}
