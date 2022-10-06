package com.loda.charSet;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

public class fileReaderCharset {
    public static void main(String[] args) throws IOException {
//        read1();
        read2();
    }

    public static void read1() throws IOException {
        Reader r = new FileReader("F:\\gbk.txt", Charset.forName("gbk"));
        int num = 0;
        while ((num = r.read()) != -1) {
            System.out.println((char) num);
        }

        r.close();
    }


    public static void read2() throws IOException {
        Reader r = new FileReader("F:\\utf8.txt", Charset.forName("utf8"));
        int num = 0;
        while ((num = r.read()) != -1) {
            System.out.println((char) num);
        }

        r.close();
    }
}
