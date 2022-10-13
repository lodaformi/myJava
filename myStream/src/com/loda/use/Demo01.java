package com.loda.use;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Demo01 {
    public static void main(String[] args) {
        String[] names = {"张龙","张彪", "李易峰", "张三丰"};

        Stream.of(names).filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        });

        Stream.of(names).filter(name -> name.startsWith("张"))
                .filter(name ->name.length() == 2)
                .forEach(name -> System.out.println(name));
    }
}
