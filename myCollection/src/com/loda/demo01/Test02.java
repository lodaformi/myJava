package com.loda.demo01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test02 {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        coll.add(2);
        coll.add(3);
        coll.add("狗娃");
        coll.add("狗剩");
        coll.add("铁蛋");
        coll.add("翠花");
        coll.add("二狗子");
        System.out.println(coll);

        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
//            coll.remove(iterator.next());
            Object obj = iterator.next();
            if("狗剩".equals(obj)){
                iterator.remove();
            }
//            coll.remove(iterator.next());
        }
        System.out.println(coll);


//        for (Object o : coll) {
////            Integer i = (Integer) o;
////            i += 3;
//            coll.remove(o);
//            System.out.println(o);
//        }
//        System.out.println(coll);


//        System.out.println(iterator.next());
//        System.out.println(iterator.next());

    }
}
