package com.loda.mybufferedInOutStream;

import java.io.*;

public class ReadDemo01 {
    public static void main(String[] args) throws IOException {
        read1();
        read2();
        read3();
    }

    public static void read1() throws IOException {
        InputStream is = new FileInputStream("F:\\movie\\太阳的后裔\\太阳的后裔E13.mp4");
        BufferedInputStream bis = new BufferedInputStream(is,1024*1024*2);

        int num = 0;
        long start = System.currentTimeMillis();
        while ((num = bis.read()) != -1) {

        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        bis.close();;
    }

    public static void read2() throws IOException {
        InputStream is = new FileInputStream("F:\\movie\\太阳的后裔\\太阳的后裔E13.mp4");
        BufferedInputStream bis = new BufferedInputStream(is, 1024*1024*2);
        byte[] by =  new byte[1024*1024];
        int len = 0;
        long start = System.currentTimeMillis();
        while ((len = bis.read(by)) != -1) {

        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        bis.close();;
    }

    public static void read3() throws IOException {
        InputStream is = new FileInputStream("F:\\movie\\太阳的后裔\\太阳的后裔E13.mp4");
        byte[] by =  new byte[1024*1024];
        int len = 0;
        long start = System.currentTimeMillis();
        while ((len = is.read(by)) != -1) {

        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        is.close();;
    }
}
