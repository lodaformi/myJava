package com.loda.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
//        Collection coll = new LinkedList();
        Collection<Person> coll = new LinkedList<>();
//        coll.add(123);
        coll.add(new Player("tom", 18));
        coll.add(new Player("jerry", 20));

        Collection<Player> coll2 = new LinkedList<>();
        coll2.add(new Player("哈哈",20));
        coll2.add(new Player("嘻嘻",25));
        coll.addAll(coll2);

        System.out.println(coll);
    }
}
