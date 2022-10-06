package com.loda.tools;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IoTest {
    public static void main(String[] args) throws IOException {
        long start1 = System.currentTimeMillis();
//        IOUtils.copyLarge(new FileInputStream("F:\\movie\\太阳的后裔\\太阳的后裔E13.mp4"), new FileOutputStream("D:\\a.mp4"));
//        FileUtils.copyFile(new File("F:\\movie\\太阳的后裔\\太阳的后裔E13.mp4"), new File("D:\\b.mp4"));
        FileUtils.copyDirectory(new File("G:\\msb\\software\\HBuilderProjects"), new File("D:\\copyDir"));
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);


    }
}
