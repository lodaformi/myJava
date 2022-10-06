package com.loda.myInterface;

public class TestFunction {
    public static void main(String[] args) {
        Mouse m = new Mouse();
        Keyboard kb = new Keyboard();

        Laptop lt = new Laptop();
        lt.powerOn();
        lt.function(m);
        lt.function(kb);
        lt.powerOff();
    }
}
