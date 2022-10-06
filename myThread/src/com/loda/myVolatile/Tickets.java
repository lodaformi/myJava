package com.loda.myVolatile;

public class Tickets implements Runnable {
    private volatile Integer tickets = 100;

    //预定义锁对象
    private final Object lockObj = new Object();

    @Override
    public void run() {
        while (true) {
            if (tickets <= 0) {
                break;
            } else {
                System.out.println(Thread.currentThread().getName() + "卖出了第" + tickets + "张票");
                --tickets;
            }
        }
    }
}
