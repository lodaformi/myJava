package com.loda.steamWriter;

import java.io.*;

public class Test01 {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("F:\\gbk.txt");
        OutputStream os = new FileOutputStream("F:\\myutf.txt");

        InputStreamReader isr = new InputStreamReader(is, "gbk");
        OutputStreamWriter osw = new OutputStreamWriter(os, "utf8");

        char[] ch = new char[512];
        int len = 0;

        while ((len = isr.read(ch)) != -1) {
            osw.write(ch);
        }

        isr.close();
        osw.close();
    }
}
