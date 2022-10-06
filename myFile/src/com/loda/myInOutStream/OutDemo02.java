package com.loda.myInOutStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutDemo02 {
    public static void main(String[] args) throws IOException {
        OutputStream os =new FileOutputStream("aa.txt",true);

        os.write("你好".getBytes());
        os.write(97);
        os.write("hello".getBytes());

        os.close();
    }
}
