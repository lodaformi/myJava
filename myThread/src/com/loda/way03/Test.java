package com.loda.way03;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCall mc = new MyCall();

        FutureTask<Integer> ft1 = new FutureTask<>(mc);
        FutureTask<Integer> ft2 = new FutureTask<>(mc);
        FutureTask<Integer> ft3 = new FutureTask<>(mc);

        Thread th1 = new Thread(ft1);
        Thread th2 = new Thread(ft2);
        Thread th3 = new Thread(ft3);

        th1.start();
        th2.start();
        th3.start();

        System.out.println(ft1.get());
        System.out.println(ft2.get());
        System.out.println(ft3.get());
    }
}
