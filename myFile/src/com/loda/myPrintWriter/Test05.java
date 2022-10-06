package com.loda.myPrintWriter;

import java.io.*;

public class Test05 {
    public static void main(String[] args) throws IOException {
        PrintWriter pw1 = new PrintWriter(new FileWriter("aa.txt"));
//        PrintWriter pw1 = new PrintWriter( System.out); //输出到标准输出，即控制台


//        System.out.println(Boolean.parseBoolean("true"));

        pw1.write("hello");
        pw1.write("world");
        pw1.write(123);
        pw1.write("周四");

        System.out.println("标准输出");
        System.setOut(new PrintStream("bb.txt"));
        System.out.println("文件输出");

            //输出不换行
//        pw1.print(123);
//        pw1.print('星');
//        pw1.print(34.123);
//        pw1.print(3.1415f);
//        pw1.print("\n");
//        pw1.print(123235145626265L);
//        pw1.print(new Person());
//        pw1.print("周四自习");

        //输出换行
        pw1.println(123);
        pw1.println('星');
        pw1.println(34.123);
        pw1.println();
        pw1.println(3.1415f);
        pw1.println(123235145626265L);
        pw1.println(new Person());
        pw1.println("周四自习");

//        pw1.append('星').append("tom").append("\n").append("巴拉巴拉").append("周四自习");



        pw1.close();

    }
}
