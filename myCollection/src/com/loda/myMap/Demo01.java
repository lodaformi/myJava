package com.loda.myMap;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();

        Double val =  map.put("tom", 60.5);
        System.out.println(val);
        val = map.put("jerry", 88.0);
        System.out.println(val);

        val = map.put("张三丰", 100.0);
        System.out.println(val);
        val = map.put("tom", 95.5);
        System.out.println(val);

        System.out.println(map);

        System.out.println(map.get("李四"));

//        System.out.println(map.containsKey("tom"));
//        System.out.println(map.containsKey("tomop"));
//        System.out.println(map.containsValue(100.0));
//        System.out.println(map.containsValue(200.0));

//        System.out.println(map.remove("张三丰"));
//        System.out.println(map.remove("张三丰"));
//        System.out.println(map.remove("张三丰",100.0));
//        System.out.println(map.size());
//        System.out.println(map);
////        map.clear();
//        System.out.println(map.isEmpty());

    }
}
