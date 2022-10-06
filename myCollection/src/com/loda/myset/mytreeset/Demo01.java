package com.loda.myset.mytreeset;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Demo01 {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();

        set.add(new Person("狗娃", 18));
        set.add(new Person("狗剩", 19));
        set.add(new Person("铁蛋", 18));
        set.add(new Person("翠花", 17));
        set.add(new Person("狗剩", 19));
        set.hashCode();

        Person p1 = new Person("狗剩", 19);
        p1.hashCode();
        System.out.println(set);
    }
}
