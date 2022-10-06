package com.loda.interrupt;

import java.util.concurrent.FutureTask;

public class Test01 {
    public static void main(String[] args) {
//        MyThread t = new MyThread();
//        t.start();
//
//        try {
//            Thread.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        t.interrupt();
//        System.out.println(t.isInterrupted());



        MyThread2 t2 = new MyThread2();
        t2.start();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt(); //  调用 interrupted()  返回true
        System.out.println(t2.isInterrupted());  // false
    }
}


class MyThread extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println("hello");
        }
    }
}