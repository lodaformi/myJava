package com.loda.polymorphism;

public class Kongzi extends KzFather {
    String name;

    Kongzi(){}
    Kongzi(String name1, String name2) {
        super(name1);
        this.name = name2;
    }
    @Override
    public void speak() {
        System.out.println("讲授论语");
    }

    public void playGame() {
        System.out.println("和平精英-王牌");
    }
}
