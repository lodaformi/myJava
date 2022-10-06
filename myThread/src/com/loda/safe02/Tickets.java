package com.loda.safe02;

public class Tickets extends Thread {
    private static Integer tickets = 100;

    public Tickets() {
    }

    public Tickets(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            if (tickets <= 0) {
                break;
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖出了第" + tickets + "张票");
                --tickets;
            }
        }
    }
}
