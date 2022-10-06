package com.loda.myset.myhashset;

import java.util.HashSet;
import java.util.Set;

public class Demo01 {
    public static void main(String[] args) {
        Set<String>  set = new HashSet<>();

        String s1 = "abc";
        String s2 = new String("abc");

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        String s3 = "通话";
        String s4 = "重地";

        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());

        set.add(s3);
        set.add(s4);
        System.out.println( set);
    }
}
