package com.loda.test;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        byte[]  by = new byte[20];
        int len = 0;
        InputStream is = new FileInputStream("poetry.txt");
        OutputStream os = new FileOutputStream("aa.txt");
        Writer w = new FileWriter("bb.txt");
        Reader r = new FileReader("poetry.txt");

//        while ((len = is.read(by))!=-1) {
//            os.write(by,0, len);
//        }

//        IOUtils.copy()
//        while ((len = IOUtils.read(is, by)) == by.length) {
//            IOUtils.write(by, os);
//        }
//        IOUtils.copy(is,os);
//        IOUtils.copy(is,w, StandardCharsets.UTF_8);

//        String s = IOUtils.toString(is, StandardCharsets.UTF_8);
//        String s2 = IOUtils.toString(r);
//        System.out.println(s);
//        System.out.println(s2);
//        byte[] by2 = IOUtils.toByteArray(is);
//        System.out.println(by2);
//        System.out.println(Arrays.toString(by2));
//        List<String> lines = IOUtils.readLines(is);
////        IOUtils.writeLines(lines, FilenameUtils.win());
//        for (String line : lines) {
//            System.out.println(line);
//        }
//        IOUtils.write("sh123enm东西", os);
//        IOUtils.write(s, os);
        is.close();
        os.close();
    }
}
