package com.loda.lamTest;

public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        GreetingSvc greetingSvc = message -> {
            long stTime1 = System.nanoTime();
            System.out.println(message);
            Thread.sleep(1000);
            long enTime1 = System.nanoTime();
            System.out.println((enTime1-stTime1)/1000 +" us");
        };
        greetingSvc.sayMessage("helloWorld");
    }
    interface GreetingSvc{
        public abstract void sayMessage(String message) throws InterruptedException;
    }
}
