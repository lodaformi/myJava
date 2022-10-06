package com.loda.way02;

public class Test {
    public static void main(String[] args) {
        Myth th1 = new Myth();

        Thread t1 = new Thread(th1);
        Thread t2 = new Thread(th1);

        t1.start();
        t2.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
    }
}
