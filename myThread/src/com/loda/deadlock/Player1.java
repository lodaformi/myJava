package com.loda.deadlock;

public class Player1 extends Thread{
    private Object remote;
    private Object battery;

    public Player1() {
    }

    public Player1(String name, Object remote, Object battery) {
        super(name);
        this.remote = remote;
        this.battery = battery;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (remote) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (battery) {
                    System.out.println(this.getName() + " play ");
                }
            }
        }

    }
}
