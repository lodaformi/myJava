package com.loda.myInterface;

abstract class A {
    public abstract void show();
}

class Test {
    public static void main(String[] args) {
    }
}

public class Keyboard  implements USB {
    @Override
    public void turnOn() {
        System.out.println("键盘开启");
    }

    @Override
    public void turnOff() {
        System.out.println("键盘关闭");
    }

    public void pressKey() {
        System.out.println("键盘输入");
    }
}
