package com.loda.traverse;

import java.io.File;
import java.io.IOException;

public class Test02 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Develop\\myJavaProjects\\myFile\\src\\a");
        System.out.println(file.exists());
//        System.out.println(file.isFile());
//        System.out.println(file.isDirectory());
    //        System.out.println(file.canExecute());
//        System.out.println(file.canRead());
//        System.out.println(file.canWrite());

//        for (File f : file.listFiles()) {
//            System.out.println(f);
////            System.out.println(f.delete());
//        }
//        System.out.println(file.delete());

//        for (String s : file.list()) {
//            System.out.println(s);
//        }
//        file.createNewFile();
//        System.out.println(file.createNewFile());
//        System.out.println(file.mkdir());
//        System.out.println(file.renameTo(new File("aaa")));

        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalFile());
        System.out.println(file.getCanonicalPath());

        System.out.println(file.getName());
        System.out.println(file.getPath());
    }

}
