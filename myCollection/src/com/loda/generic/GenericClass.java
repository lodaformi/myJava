package com.loda.generic;

public class GenericClass<T> {
    T t;
    public void show(T t) {
        System.out.println(t);
    }

    public T method(T t) {
        return t;
    }
}
