package com.loda.myclone;

import com.loda.myclone02.Item;

public class Test01 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Car c1 = new Car("BYD-tang", "BYD", new Engine("v8","2.5T"));
        System.out.println(c1);
        Car c2 = c1.clone();
        System.out.println(c2);

        System.out.println(c1.engine);
        System.out.println(c2.engine);
    }
}
