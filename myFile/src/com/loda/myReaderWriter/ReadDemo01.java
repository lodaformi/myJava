package com.loda.myReaderWriter;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadDemo01 {
    public static void main(String[] args) throws IOException {
        read1();
        read2();
    }

    public static void read1() throws IOException {
        Reader r = new FileReader("F:\\movie\\太阳的后裔\\太阳的后裔E13.mp4");
        int num = 0;
        long start = System.currentTimeMillis();
        while ((num = r.read()) != -1) {
            System.out.println(num);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void read2() throws IOException {
        Reader r = new FileReader("F:\\movie\\太阳的后裔\\太阳的后裔E13.mp4");
        int num = 0;
        char[] ch = new char[1024];
        long start = System.currentTimeMillis();
        while ((num = r.read(ch)) != -1) {

        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
