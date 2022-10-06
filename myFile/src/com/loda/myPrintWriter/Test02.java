package com.loda.myPrintWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Test02 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
//        PrintWriter pw1 = new PrintWriter(new File("./aa.txt"), "gbk");
        PrintWriter pw1 = new PrintWriter(new File("./aa.txt"), "utf8");

//        pw1.write("hello");
//        pw1.write("world");
//        pw1.write(123);
//        pw1.write("周四");

            //输出不换行
//        pw1.print(123);
//        pw1.print('星');
//        pw1.print(34.123);
//        pw1.print(3.1415f);
//        pw1.print(123235145626265L);
//        pw1.print(new Person());
//        pw1.print("周四自习");

        //输出换行
//        pw1.println(123);
//        pw1.println('星');
//        pw1.println(34.123);
//        pw1.println();
//        pw1.println(3.1415f);
//        pw1.println(123235145626265L);
//        pw1.println(new Person());
//        pw1.println("周四自习");

        pw1.append('星').append("tom").append("\n").append("巴拉巴拉").append("周四自习");



        pw1.close();

    }
}
