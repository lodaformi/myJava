package com.loda.deadlock;

public class Player2 extends Thread{
    private Object remote;
    private Object battery;

    public Player2() {
    }

    public Player2(String name, Object remote, Object battery) {
        super(name);
        this.remote = remote;
        this.battery = battery;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (battery) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (remote) {
                    System.out.println(this.getName() + " play！！");
                }
            }
        }

    }
}
