package com.loda.safe01;

public class Tickets extends Thread {
    private Integer tickets = 100;

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
                System.out.println(Thread.currentThread().getName() + "卖出了第" + tickets + "张票");
                --tickets;
            }
        }
    }
}
