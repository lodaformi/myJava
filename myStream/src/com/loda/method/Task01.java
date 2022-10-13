package com.loda.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 1. int[] arr = {5, 3, 6, 10, 2, 7}，控制台输出数组每个数字的平方


 2.找到数组中的最小数据

 */
public class Task01 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 10, 2, 7};
        List<Integer> arrList = new ArrayList<>();
        for (int i : arr) {
//            System.out.println(i);
            arrList.add(i);
        }

        //List.of和Stream.of不能直接读出数组的每个元素值
        //转换后流后，还是个数组
//        List.of(arr).stream().forEach(num-> System.out.println(num));
        Stream.of(arr).forEach(num -> {
            for (int i : num) {
                System.out.print(i * i + "\t");
            }
        });
        System.out.println();

        arrList.stream().forEach(num -> System.out.println(num * num));
        System.out.println("------------");

        System.out.println(Arrays.stream(arr));
        Arrays.stream(arr).forEach(num -> System.out.println(num * num));
        System.out.println("------------");
        System.out.println(Arrays.stream(arr).sorted().toArray()[0]);

//        System.out.println(Arrays.stream(arr).sorted().findFirst());

//        Object o = Stream.of(arr).sorted().toArray()[0];
//        System.out.println(o);
    }
}
