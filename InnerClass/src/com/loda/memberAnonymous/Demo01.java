package com.loda.memberAnonymous;

public class Demo01 {
    public static void main(String[] args) {
        Body bd = new Body();
        bd.show();

        Body.Heart bh = bd.new Heart();
        bh.show();
        //类外不能直接访问私有变量
//        System.out.println(bh.i);
        bh.heardBeat();

        bd.setAlive(true);
        bh.heardBeat();
    }
}
