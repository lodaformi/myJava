package com.loda.myString;

public class Demo01 {
    public static void main(String[] args) {
        String s = new String("helloWorld");
        System.out.println(s.indexOf('o'));

//        String s1 = "abc" + "def";
//        String s2 = "abcdef";
//        System.out.println(s1 == s2); //true

            String s3 = "abc";
            String s4 = s3 + "def";
            String s5 = "abcdef";
        System.out.println(s4 ==  s5);
        System.out.println(s4.equals(s5));

        System.out.println("-----------------");

//
//        String s5 = "hello" + "world";
//        String s6 = "helloworld";
//        System.out.println(s5 == s6);
//        System.out.println(s5.equals(s6));



        String s6 = "helloworld";
        String s7 = "hello";
        String s8 = "world";
        String s9 = s7 + s8;                                                        // "helloworld"    s7 + s8   完全不同于  “hello” + "world"
        System.out.println(s9 == s6);
        System.out.println(s9.equals(s6));
    }
}
