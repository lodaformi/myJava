package com.loda.use;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Demo04 {
    public static void main(String[] args) {
        List<String> list1 = List.of("狗娃","翠花","狗剩","铁蛋","狗儿子");
        List<String> list2 = List.of("刘亦菲","柳岩","迪丽热巴","贾玲","陈冠西");
        Stream<String> gou = list1.stream().filter(name -> name.startsWith("狗")).filter(name -> name.length() == 2);
        Stream<String> stringStream = list2.stream().filter(name -> name.length() == 3);

        Stream<String> concat = Stream.concat(gou, stringStream);
//        concat.forEach(name-> System.out.println(name));
//        concat.map(name-> new Person(name)).forEach(person -> System.out.println(person));
        concat.map(Person::new).forEach(System.out::println);

    }
}
