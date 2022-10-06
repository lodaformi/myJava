package com.loda.tools;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class FileTest01 {
    public static void main(String[] args) throws IOException {

        InputStream is = FileUtils.openInputStream(new File("aa.txt"));
        OutputStream os = FileUtils.openOutputStream(new File("bb.txt"));

        byte[] by = new byte[60];
        int len = 0;
        while ((len = is.read(by)) != -1) {
            os.write(by, 0, len);
        }
        os.flush();

        is.close();
        os.close();
    }
}
