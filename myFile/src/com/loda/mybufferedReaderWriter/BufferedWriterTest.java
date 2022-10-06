package com.loda.mybufferedReaderWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class BufferedWriterTest {
    public static void main(String[] args) throws IOException {
        Writer w = new FileWriter("aa.txt", true);
        BufferedWriter bw = new BufferedWriter(w);

        bw.write("纸上得来终觉浅");
        bw.newLine();
        bw.write("绝知此事要躬行");

        bw.flush();
        bw.close();
    }
}
