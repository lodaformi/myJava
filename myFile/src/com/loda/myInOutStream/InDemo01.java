package com.loda.myInOutStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InDemo01 {
    public static void main(String[] args) throws IOException {
        readFile1();
//        readFile2();
    }

    public static void readFile1() throws IOException {
        InputStream is = new FileInputStream("F:\\movie\\太阳的后裔\\太阳的后裔E13.mp4");
        int num = 0;
        long start = System.currentTimeMillis();
        while ((num=is.read())!=-1){
//            System.out.println(num);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        is.close();
    }

    public static void readFile2() throws IOException {
        InputStream is = new FileInputStream("F:\\movie\\太阳的后裔\\太阳的后裔E13.mp4");
        byte[] by = new byte[1024];
        int len = 0;
        long start = System.currentTimeMillis();
        while ((len=is.read(by))!=-1){

        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        is.close();
    }
}
