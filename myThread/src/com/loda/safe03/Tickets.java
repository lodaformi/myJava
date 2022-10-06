package com.loda.safe03;

public class Tickets implements Runnable {
    private Integer tickets = 500;

    //预定义锁对象
    private final Object lockObj = new Object();

    @Override
    public void run() {
        while (true) {
            //同步代码块
            synchronized (this) {
                if (tickets <= 0) {
                    break;
                } else {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出了第" + tickets + "张票");
                    --tickets;
                }
            }
        }
    }
}
