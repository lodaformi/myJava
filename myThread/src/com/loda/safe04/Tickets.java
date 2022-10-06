package com.loda.safe04;

public class Tickets implements Runnable {
//    private Integer tickets = 200;
    private static Integer tickets = 200;

    @Override
    public void run() {
        while (true) {
            safe();
//            safe2();
        }
    }

//    public synchronized void safe() {
//        if (tickets > 0) {
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "卖出了第" + tickets + "张票");
//            --tickets;
//        }
//    }

    public  void safe() {
        synchronized(this) {
            if (tickets > 0) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖出了第" + tickets + "张票");
                --tickets;
            }
        }

    }

//    public static synchronized void safe2() {
//        if (tickets > 0) {
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "卖出了第" + tickets + "张票");
//            --tickets;
//        }
//    }



    public static void safe2() {
        synchronized (Tickets.class) {
            if (tickets > 0) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖出了第" + tickets + "张票");
                --tickets;
            }
        }
    }
}
