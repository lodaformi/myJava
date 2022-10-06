package com.loda.myAbstract;

public abstract class Dog extends Animal{
    public abstract void guide();

    public void eat() {
        System.out.println("狗吃骨头");
    }
    public abstract void show();
}
