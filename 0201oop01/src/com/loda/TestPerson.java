package com.loda;

public class TestPerson {
    public static void main(String[] args) {
        Person p1 = new Person();
        System.out.println(p1);
        p1.setName("tom");
        p1.setAge(1000);
        p1.setSex('a');
        System.out.println(p1);
    }
}
