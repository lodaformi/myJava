package com.loda.polymorphism02;

public class Mytest {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.eat();

        Cat c1 = new Cat();
        c1.eat();

        System.out.println("------------");
        Animal a1 = new Dog();
//        a1.eat();
//        a1.work();
        Animal a2 = new Cat();
//        a2.eat();
//        a2.work();

        // 类型转换异常
//        Cat c2 = (Cat) a1;
//        System.out.println(a1 instanceof Cat);
//        System.out.println(a1 instanceof Animal);
//        System.out.println(a1 instanceof Dog);

        System.out.println(Animal.age);
        a1.show();
        a2.show();
    }

}
