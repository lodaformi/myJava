package com.loda.myFinal;

import java.util.Arrays;

public class TestFinal {
    public static void main(String[] args) {
//        Person p = new Person();
        System.out.println(Person.country);
//        Person.country = "china";

        final int[] arr = new int[] {5,3,2,9};
        System.out.println(Arrays.toString(arr));
        arr[2]=100;
        System.out.println(Arrays.toString(arr));

        //不能改变指向
//        arr = new int[]{78,123};

        final Person p = new Person();
        System.out.println(p);
        //不能改变指向
//        p = new Person();
        p.setName("hh");
        System.out.println(p);
    }
}
