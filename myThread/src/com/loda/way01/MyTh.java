package com.loda.way01;

public class MyTh extends Thread{
    public MyTh() {
    }

    public MyTh(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
    }
}
