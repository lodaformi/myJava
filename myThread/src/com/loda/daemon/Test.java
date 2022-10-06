package com.loda.daemon;

public class Test {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Person(), "张飞");
        Thread t2 = new Thread(new Person(), "关羽");
        Thread t3 = new Thread(new Person2(), "刘备");
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.setDaemon(true);
        t2.setDaemon(true);

        t1.start();
        t2.start();
        t3.start();
    }
}
