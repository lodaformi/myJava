package com.loda.use;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Demo02 {
    public static void main(String[] args) {
        //list
        List<Integer> list = List.of(11,22,33,44);
        Stream<Integer> integerStream = list.stream();
        integerStream.forEach(num-> System.out.print(num + "\t"));
        System.out.println();

        //set集合，存入和取出无序
        Set<String> set = Set.of("abc","xyz","www","http", "https");
        Stream<String> setStream = set.stream();
        setStream.forEach(str -> System.out.print(str+"\t"));
        System.out.println();

        //map key
        Map<String, Integer> map = Map.of("张龙",12,"张彪",15, "tom", 12);
        Stream<String> nameStream = map.keySet().stream();
        nameStream.forEach(name -> System.out.print(name + "\t"));
        System.out.println();

        //map value
        Stream<Integer> valStream = map.values().stream();
        valStream.forEach(val -> System.out.print(val +"\t"));
        System.out.println();

        //map entryset
        Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();
        entryStream.forEach(es -> System.out.println(es.getKey()
                + ":" +es.getValue()));

        //单个元素
        Stream<Integer> s1 = Stream.of(11,22,33,44);
        s1.forEach(num -> System.out.print(num+"\t"));
//        s1.forEach(num -> System.out.print(num+"\t"));
        System.out.println();

        Stream<Integer> s2 = Stream.of(new Integer[]{55,66,77});
        s2.forEach(num-> System.out.print(num+"\t"));
        System.out.println();

        //
        int[] it1 = new int[]{22,33,44,55};
//        Stream<int[]> it11 = Stream.of(it1);

        Stream.of(it1).forEach(num-> System.out.print(num+"\t"));
        System.out.println();

        Double[] d = {1.1,2.2,3.3};
        Stream<Double> d2 = Stream.of(d);
        d2.forEach((dNum)-> System.out.println(dNum*2));
    }
}
