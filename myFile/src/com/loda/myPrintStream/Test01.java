package com.loda.myPrintStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class Test01 {
    public static void main(String[] args) throws IOException {
        PrintStream ps = new PrintStream("aa.txt");

//        ps.write(123);
//        ps.write(new byte[]{97,98,48});
//
//        ps.println(123);
//        ps.println(3.1415f);
//        ps.println("hello");


        ps.append('过').append("中").append("12").append("\n").append("false").append('0');


        ps.close();
    }
}
