package com.loda.mycollection;

import com.loda.clone.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("hello");
        list.add(new Student());
        list.add(123);
        list.add(3.124);

        System.out.println(list.contains(123));
        System.out.println(Integer.valueOf(123) == null);
        System.out.println(list);

        Object[] obj = new Object[5];
        obj[0] = "hello";
        obj[1] = new Student();
        obj[2] = 123;
        obj[3] = 3.1415f;
        System.out.println(obj);

        System.out.println(Arrays.toString(obj));


        Integer n = 5;
        int hash = new Student().hashCode();
        System.out.println(hash);
        // len = 9
        System.out.println( 63 & hash);
    }
}
