package com.loda.myjoin;

public class PlayMj extends Thread{
    @Override
    public void run() {
        Drink dr = new Drink();
        dr.start();
        try {
            dr.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("开始打麻将");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("赢钱真开心");
    }
}
