package com.loda.generic;

public class TestGenericClass {
    public static void main(String[] args) {
        GenericClass<Double> gc = new GenericClass<>();

        gc.t = 33.2;
        System.out.println(gc.t);

        gc.show(4000.67);
        System.out.println(gc.method(88999.22));
    }
}
