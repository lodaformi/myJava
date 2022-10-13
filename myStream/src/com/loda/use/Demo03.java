package com.loda.use;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Demo03 {
    public static void main(String[] args) {
        List<Student> stuList = new ArrayList<>();
        stuList.add(new Student("tom", 23));
        stuList.add(new Student("tome", 18));
        stuList.add(new Student("clark", 20));
        stuList.add(new Student("tom", 23));


        stuList.stream().filter(stu->stu.getName().startsWith("to"))
                        .filter(stu ->stu.getAge() >= 20)
                .forEach(student -> System.out.println(student));

        System.out.println("---------");
        stuList.stream().map(student -> {
            student.setAge(student.getAge() +1 );
            return student;
        }).forEach(student -> System.out.println(student));
        System.out.println("---------");


        //返回由此流的不同元素（根据 Object.equals(Object) ）组成的流。
        //要看自定义对象有没有重写equals方法
        stuList.stream().distinct().forEach(student -> System.out.println(student));
        System.out.println(stuList.stream().distinct().count());
        System.out.println("---------");

        //显示前2条
        stuList.stream().limit(2).forEach(System.out::println);
        System.out.println("---------");
        //跳过前2条
        stuList.stream().skip(2).forEach(System.out::println);

    }
}
