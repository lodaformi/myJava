package com.loda.method;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 1. int[] arr = {5, 3, 6, 10, 2, 7}，控制台输出数组每个数字的平方


 2.找到数组中的最小数据

 */
public class Task02 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 10, 2, 7};

        //1
        Arrays.stream(arr).forEach(num-> System.out.print(num*num + "\t"));
        System.out.println();

        //2
        System.out.println(Arrays.stream(arr).sorted().toArray()[0]);

        System.out.println("-------------");

        Integer[] arr2 = {5, 3, 6, 10, 2, 7};
        Stream.of(arr2).forEach(num-> System.out.print(num*num + "\t"));
        System.out.println();

        System.out.println(Stream.of(arr2).sorted().toArray()[0]);
    }
}
