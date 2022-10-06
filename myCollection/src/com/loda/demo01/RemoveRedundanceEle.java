package com.loda.demo01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RemoveRedundanceEle {
    public static void main(String[] args) {
        Collection cl = new ArrayList();
        cl.add(12);
        cl.add("abc");
        cl.add("abc");
        cl.add(new Person("来宪龙", 29));
        cl.add("中国");
        cl.add("星期六");
        cl.add(false);
        cl.add("中国");
        cl.add(new Person("来宪龙",29));
        cl.add("星期六");
        System.out.println(cl);

        cl.remove("abc");
        System.out.println(cl);
//        cl.clear();
//        cl.removeAll(cl);
        System.out.println(cl);
        // method 1
//        Collection cl2 = new ArrayList();
//        Iterator iterator = cl.iterator();
//        while (iterator.hasNext()) {
//            Object o = iterator.next();
//            if (!cl2.contains(o)) {
//                cl2.add(o);
//            }
//        }
//        System.out.println(cl2);

        //method 2
//        Collection cl2 = new ArrayList();
//        for (Object o : cl) {
//            while (!cl2.contains(o)){
//                cl2.add(o);
//            }
//        }
//        System.out.println(cl2);
    }
}
