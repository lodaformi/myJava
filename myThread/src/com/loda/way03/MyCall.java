package com.loda.way03;

import java.util.concurrent.Callable;

public class MyCall implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Integer sum = 0;
        for (int i = 1; i <= 50; i++) {
            sum += i;
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
        return sum;
    }
}
