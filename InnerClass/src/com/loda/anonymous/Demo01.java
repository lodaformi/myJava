package com.loda.anonymous;

public class Demo01 {
    public static void main(String[] args) {
        new Pay() {
            @Override
            public void pay() {
                System.out.println("支付宝支付");
            }
        }.pay();
    }
}

abstract class Phone implements Pay{
    public void call() {
        System.out.println("打电话");
    }

}

interface Pay {
    public static final double money =100;
    public abstract void pay();
}
