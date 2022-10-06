package com.loda.safe03;

public class Test {
    public static void main(String[] args) {
        Tickets ti = new Tickets();
        Thread th1 = new Thread(ti, "窗口1");
        Thread th2 = new Thread(ti, "窗口2");
        Thread th3 = new Thread(ti, "窗口3");

        th1.start();
        th2.start();
        th3.start();
    }
}
