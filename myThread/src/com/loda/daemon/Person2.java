package com.loda.daemon;

public class Person2 implements Runnable {
    @Override
    public void run() {
        int i = 0;
        for (int j = 0; j < 20; j++) {
            System.out.println(Thread.currentThread().getName() +"--"+ i);
            ++i;
        }
    }
}
