package com.loda.mybufferedReaderWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Test01 {
    public static void main(String[] args) throws IOException {
        Writer w = new FileWriter("b.txt", true);
        BufferedWriter bw = new BufferedWriter(w);

        bw.write("明天是星期几？");
        bw.newLine();
        bw.write("9月28号是星期三。");
        bw.newLine();
        bw.write("hhh");

        bw.flush();
        bw.close();
        bw.close();
    }
}
