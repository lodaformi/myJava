package com.loda.myset.exam;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Demo01 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(1);
        set.add(4);
        set.add(5);

        System.out.println(set);


        Set<Integer> tset = new TreeSet<>();
        tset.add(5);
        tset.add(10);
        tset.add(1);
        tset.add(3);
        System.out.println(tset);


        Set<String> set2 = new HashSet<>();
        set2.add("tom");
        set2.add("tome");
        set2.add("jerry");
        set2.add("android");
        System.out.println(set2 );


    }

}
