package com.loda.myMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapTraverse {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("tom", 10000.0);
        map.put("jerry", 12000.0);
        map.put("jack", 8500.0);

//        traverse1(map);
        traverse2(map);
    }

    public static void traverse1(Map<String, Double> map) {
//        Set<String> set = map.keySet();
//
//        for (String key : set) {
//            Double val = (Double) map.get(key);
//            System.out.println(key +" : "+val);
//        }

        //opti
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }

    public static void traverse2(Map<String, Double> map) {
//        Set<Map.Entry<String, Double>> set = map.entrySet();
//
//        for (Map.Entry<String, Double> entry : set) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

        //opti
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}
