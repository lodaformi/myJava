package com.loda.test02;

import com.loda.test01.Demo01;

public class Test01 {
    public static void main(String[] args) {
        Demo01 dm = new Demo01();
//        System.out.println(dm.a);
        //不同包下，无关类创建对象，无法访问非公有成员
//        System.out.println(dm.b);
//        System.out.println(dm.c);
//        System.out.println(dm.d);
        //不同包下，无关类创建对象，无法访问非公有成员
//        dm.show();
//        dm.show2();
//        dm.show3();
//        dm.show4();

        Zi zi = new Zi();
        System.out.println(zi.a);
//        System.out.println(zi.b);
        zi.ziShow();
        zi.show();
//        zi.show2();
//        zi.show2();
//        zi.show3();
//        zi.show4();

    }
}
