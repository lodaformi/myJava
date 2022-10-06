package com.loda.polymorphism;

public class TestKongzi {
    public static void main(String[] args) {
        KzFather kf = new Kongzi("孔子爹", "孔子");
        System.out.println(kf.name);

        kf.speak();
//        kf.playGame();
        System.out.println("----------------");
        Kongzi kz = (Kongzi) kf;
        kz.speak();
        kz.playGame();

        System.out.println(kz instanceof Kongzi);
        System.out.println(kf instanceof Kongzi);
        System.out.println(kf instanceof KzFather);
        System.out.println(kz instanceof  KzFather);

    }
}
