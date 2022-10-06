package com.loda.interrupt;

public class Test02 {
    public static void main(String[] args) {
        MyThread3 my3 = new MyThread3();

        my3.start();

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        my3.interrupt();
        System.out.println(my3.isInterrupted());
    }
}


class MyThread3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }
//        int i = 0;
//        while (!Thread.currentThread().isInterrupted()) {
//            System.out.println(Thread.currentThread().getName()+"--"+ (i++));
//        }
    }
}
