package com.loda.safe02;

public class Test {
    public static void main(String[] args) {
        Tickets ti1 = new Tickets("窗口1");
        Tickets ti2 = new Tickets("窗口2");
        Tickets ti3 = new Tickets("窗口3");

        ti1.start();
        ti2.start();
        ti3.start();
    }
}
