package com.loda.InterfaceDemo01;

public interface Inc {
    public final static int cnt = 10;
    public static final  int cnt2 = 10;

    public abstract void show();

    public default void show2() {
        method();
    }
    public default void show3() {
        method();
    }
    public default void show4() {
        method();
    }

    private void method() {
        System.out.println("abc");
        System.out.println("abc");
    }
}
