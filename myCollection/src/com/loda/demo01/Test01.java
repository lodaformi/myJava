package com.loda.demo01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class Test01 {
    public static void main(String[] args) {
        Collection cl = new ArrayList();
        cl.add(12);
        cl.add("abc");
        cl.add(new Person("tom",12));
        cl.add('中');
        cl.add(true);
        cl.add("星期六");
        cl.add(34.56);
        System.out.println(cl);
//        cl.clear();
        System.out.println(cl.isEmpty());

        Collection cl2 = new ArrayList();
        Person p1 = new Person("tom",12);
        cl2.add(p1);
        cl2.add("abc");
        cl.addAll(cl2);
        System.out.println(cl);

        cl.remove(new Person("tom",12));
        System.out.println(cl);

//        Object[] arr = cl.toArray();
//        for (Object o : arr) {
//            System.out.println(o);
//        }


//        Iterator iterator = cl.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }


//        Collection coll = new ArrayList();
//        coll.add(new Person("tom", 12));
//        Person p1 = new Person("tom", 12);
//        coll.add(p1);
//        coll.add(123);
//        coll.add("tom");
//        System.out.println(coll);
//        System.out.println(coll.contains(p1));
//        coll.remove(123);
//        System.out.println(coll);
//        Object obj = coll.toArray();
//
//        System.out.println(obj.toString());
    }
}
