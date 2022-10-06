package com.loda.way01;

public class Test {
    public static void main(String[] args) {
        MyTh mt1 = new MyTh();
        MyTh mt2 = new MyTh("myth2");

        //串行执行
//        mt1.run();
//        mt2.run();

        mt1.start();
        mt2.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
    }
}
