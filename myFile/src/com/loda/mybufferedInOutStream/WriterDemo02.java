package com.loda.mybufferedInOutStream;

import java.io.*;

public class WriterDemo02 {
    public static void main(String[] args) throws IOException {
        OutputStream os = new FileOutputStream("aa.txt", false);
        BufferedOutputStream bos = new BufferedOutputStream(os);

        bos.write("纸上得来终觉浅2\n".getBytes());
        bos.write("绝知此事要躬行2\n".getBytes());

        bos.flush();
        bos.close();
    }
}
