package com.loda.test01;

public class Demo01 {
    public int a = 10;
    protected int b = 20;
    private int c = 30;
    int d = 40;

    public Demo01() {
    }

    public Demo01(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void show() {
        System.out.println("show "+a);
        System.out.println("show "+b);
        System.out.println("show "+c);
        System.out.println("show "+d);
    }

    protected void show2() {
        System.out.println("show2 "+a);
        System.out.println("show2 "+b);
        System.out.println("show2 "+c);
        System.out.println("show2 "+d);
    }

    private void show3() {
        System.out.println("show3 "+a);
        System.out.println("show3 "+b);
        System.out.println("show3 "+c);
        System.out.println("show3 "+d);
    }

    void show4() {
        System.out.println("show4 "+a);
        System.out.println("show4 "+b);
        System.out.println("show4 "+c);
        System.out.println("show4 "+d);
    }

    /**
     * 获取
     * @return a
     */
    public int getA() {
        return a;
    }

    /**
     * 设置
     * @param a
     */
    public void setA(int a) {
        this.a = a;
    }

    /**
     * 获取
     * @return b
     */
    public int getB() {
        return b;
    }

    /**
     * 设置
     * @param b
     */
    public void setB(int b) {
        this.b = b;
    }

    /**
     * 获取
     * @return c
     */
    public int getC() {
        return c;
    }

    /**
     * 设置
     * @param c
     */
    public void setC(int c) {
        this.c = c;
    }

    public String toString() {
        return "Demo01{a = " + a + ", b = " + b + ", c = " + c + "}";
    }
}
