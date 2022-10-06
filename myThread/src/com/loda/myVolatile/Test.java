package com.loda.myVolatile;


public class Test {
    public static void main(String[] args) {
        Tickets ti = new Tickets();
        Thread th1 = new Thread(ti);
        Thread th2 = new Thread(ti);
        Thread th3 = new Thread(ti);

        th1.start();
        th2.start();
        th3.start();
    }
}

