package com.loda.traverse;

import java.io.File;

public class Test01 {
    public static void main(String[] args) {
        CopyDir cd = new CopyDir();
        long start = System.currentTimeMillis();
        cd.copyDir(new File("G:\\msb\\software\\HBuilderProjects"), new File("D:\\hbPro"));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
