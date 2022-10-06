package com.loda.myReaderWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteDemo02 {
    public static void main(String[] args) throws IOException {
        Writer w = new FileWriter("aab.txt", true);
        w.write("new");
        w.write("今天天气真好");
        w.write(123);
        w.write("\n");
        w.write(new char[]{97,98,99});
        w.flush();
        w.close();
    }
}
