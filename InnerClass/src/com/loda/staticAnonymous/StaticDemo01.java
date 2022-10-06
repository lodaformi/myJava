package com.loda.staticAnonymous;

public class StaticDemo01 {
    public static void main(String[] args) {
//        Outer.Inner oi = new Outer.Inner();
////        oi.show();
//        oi.show2();
//        Outer.Inner.show();
        Outer o = new Outer();
        o.method();
    }
}

class Outer {
    int i = 10;
    static int j = 20;

    static class Inner {
        int m = 30;
        static int n = 40;

        public static void show() {
            //静态内部类静态方法不能访问外部类非静态变量
//            System.out.println(i);
            System.out.println(j);
            //静态内部类不能访问本类非静态变量
//            System.out.println(m);
            System.out.println(n);
        }

        public void show2() {
            //静态内部类普通方法不能访问外部类非静态变量
//            System.out.println(i);
            System.out.println(j);
            System.out.println(m);
            System.out.println(n);
        }
    }

    public void method() {
        System.out.println(i);
        System.out.println(j);
        //外部类不能直接访问内部类成员
//        System.out.println(m);
//        System.out.println(n);
//        show2();
        new Inner().show2();
    }
}