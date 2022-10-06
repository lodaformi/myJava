package com.loda.tools;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class IOTest02 {
    public static void main(String[] args) throws IOException {
        String name = "G:\\msb\\software\\HBuilderProjects\\hello38Snake.html";
//        OutputStream os = new FileOutputStream("bb.html");
//        byte[] by = new byte[20];
//        InputStream in = new FileInputStream(name);
//        int len = 0;
//        while ((len = IOUtils.read( in, by)) != 20) {
//            IOUtils.write(by, os );
//        }
        IOUtils.copy(new FileInputStream(name), new FileOutputStream("bb.html") );

    }
}
