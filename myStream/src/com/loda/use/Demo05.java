package com.loda.use;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Demo05 {
    public static void main(String[] args) {
        Double[] d = {1.1,2.2,3.3,4.4};
        Stream.of(d).filter(new Predicate<Double>() {
            @Override
            public boolean test(Double aDouble) {
                return false;
            }
        });

        Stream.of(d).filter((dNum)-> dNum != 2.2).forEach((dNum)-> System.out.println(dNum));
        System.out.println("----------");
        Stream.of(d).filter((dNum)-> dNum != 2.2).forEach(System.out::println);
        System.out.println("----------");

        Arrays.stream(d).filter((dNum)-> dNum != 3.3).map((dNum)-> dNum + 10.10).forEach(System.out::println);
    }
}
