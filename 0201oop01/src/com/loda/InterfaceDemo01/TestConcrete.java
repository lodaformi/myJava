package com.loda.InterfaceDemo01;

public class TestConcrete {
    public static void main(String[] args) {
        System.out.println(Inc.cnt);
        System.out.println(Inc.cnt2);
        Concrete cc = new Concrete();
        cc.show();
//        cc.show2();
//        cc.show3();
//        cc.show4();

        Inc ic = new Concrete();
        System.out.println(ic instanceof Inc);


    }

}
