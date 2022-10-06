package com.loda.myList;

import java.util.*;

public class Demo01 {
    public static void main(String[] args) {
        List list  = new ArrayList();
        list.add(5);
        list.add(0,"zhong");

        list.add(5);
        list.add(2,false);
        list.add("zhong");
        list.add(3.1415);
        System.out.println(list);
//        System.out.println(list.get(0));
//        System.out.println(list.indexOf(5));
//        //传入的数字会被当成索引，如果想删除对应的数字，需用包装类装箱
////        list.remove(5);
//        list.remove(Integer.valueOf(5));
        System.out.println(list);
        System.out.println("------------------");
        List list3 = list.subList(1,4);
        System.out.println(list3);

        Set<Integer> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

//        ListIterator listIterator = list.listIterator();
//        while (listIterator.hasNext()){
//            //获取当前位置的索引
//            Integer idx = listIterator.nextIndex();
//            System.out.println(idx);
//            //迭代器后移一位，不移位的话，会形成死循环
//            Object obj = listIterator.next();
//            System.out.println(list.get(idx));
////            System.out.println(listIterator.next());
//        }

        // 集合不可修改
//        List list2 = List.of("中国", true, 2.45, 89);
//        System.out.println(list2);
//        list2.remove(3);
//        list2.add(new User());  //报错UnsupportedOperationException

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t");
        }
        System.out.println();
    }
}
