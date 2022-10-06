package com.loda.sysexception;

import com.loda.customexception.Student;

public class Test01 {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println(s1.getClass());
        System.out.println(s1.getClass().getName());
        System.out.println(s1);

//        System.out.println(Integer.parseInt("12.4a"));
    }
}
