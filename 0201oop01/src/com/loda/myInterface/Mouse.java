package com.loda.myInterface;

public class Mouse implements USB{

    @Override
    public void turnOn() {
        System.out.println("鼠标开启");
    }

    @Override
    public void turnOff() {
        System.out.println("鼠标关闭");
    }

    public void click() {
        System.out.println("鼠标点击");
    }
}
