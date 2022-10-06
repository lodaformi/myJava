package com.loda.traverse;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.File;

public class Traverse {
    public static void main(String[] args) {
        File file = new File("G:\\msb\\software\\HBuilderProjects-copy");
//        System.out.println(file.isFile());
//        System.out.println(file.isDirectory());

//        String[] lists = file.list();
//        for (String list : lists) {
//            System.out.println(list);
//        }

//        File[] files = file.listFiles();
//        for (File f : files) {
//            System.out.println(f.getName());
//        }

//        deleteDG(file);
//        file.delete();
    }

    public static void traverseDG(File file) {
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
//                System.out.println(f.getName());
                traverseDG(f);
                f.delete();
            }else {
                f.delete();
//                System.out.println(f.getName());
            }
        }
    }

    public static void deleteDG(File file) {
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                deleteDG(f);
                f.delete();
            }else {
                f.delete();
            }
        }
    }

    public static void deleteDG2(File file) {
        if (file.isFile()) {
            file.delete();
        }else {
//            if ()
        }
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                deleteDG(f);
                f.delete();
            }else {
                f.delete();
            }
        }
    }
}
