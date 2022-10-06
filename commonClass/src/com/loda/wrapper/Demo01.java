package com.loda.wrapper;

public class Demo01 {
    public static void main(String[] args) {

//        Integer i1 = new Integer(3);
//        Integer i2 = new Integer("123");
//        System.out.println(i1);
//        System.out.println(i2);

        Integer i3 = 2;
        Integer i4 = Integer.valueOf(5);

        Integer i5 = 100;
        System.out.println(i5);
        System.out.println(i5.intValue());
        System.out.println(i5.toString());

        String s = "345";
        System.out.println(Integer.parseInt(s));

        Integer i6 = 128;
        Integer i7 = 128;
        System.out.println(i6 == i7);
    }
}
