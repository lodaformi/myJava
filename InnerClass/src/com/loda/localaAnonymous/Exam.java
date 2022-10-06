package com.loda.localaAnonymous;


public class Exam {
    public static void main(String[] args) {
        Person p = new Person();
        p.method();
    }
}

class Person {
    String name;

    public void method() {
//        int i = 10;
//        i = 20;
        //在局部内部类中访问局部变量，该变量须是常量，最好把final修饰符加上去
        final int i = 10;
        class Emp {
            public void show() {
                System.out.println(i);
            }
        }

        Emp emp = new Emp();
        emp.show();
    }
}
