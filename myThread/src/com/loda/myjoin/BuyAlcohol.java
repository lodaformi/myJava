package com.loda.myjoin;

public class BuyAlcohol extends Thread {
    @Override
    public void run() {
        System.out.println("去买酒");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("买酒回来了");
    }
}
