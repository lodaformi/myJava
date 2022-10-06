package com.loda.myjoin;

public class Drink extends Thread {
    @Override
    public void run() {
        BuyAlcohol ba = new BuyAlcohol();
        ba.start();
        try {
            ba.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("开始喝酒");
        System.out.println("喝酒中");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("酒足饭饱");
    }
}
