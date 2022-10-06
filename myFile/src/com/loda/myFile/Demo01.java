package com.loda.myFile;

import java.io.File;

public class Demo01 {
    public static void main(String[] args) {
//        File f = new File("G:\\msb\\software\\HBuilderProjects");
        File f = new File("aaa");

        //s只有文件名和文件夹名
//        for (String s : f.list()) {
//            System.out.println(s);
//        }
        //file表示创建该对象的路径
//        for (File file : f.listFiles()) {
//            System.out.println(file.getAbsolutePath());
//        }
//        showDirRec(f, 0);
//        delDirRec(f);
//        System.out.println(f.listFiles().length);
//        for (File file : f.listFiles()) {
//            System.out.println(file);
//        }
        System.out.println(new File("aaa").delete());

    }

    public static String getSep(int cnt) {
        String sep = "";
        for (int i = 0; i < cnt; i++) {
            sep += "-";
        }
        return sep;
    }

    public static void showDirRec(File file, int cnt) {
        if (!file.exists()) return;
        String sep = getSep(cnt);
        //如果是文件，则打印后，退出
        if (file.isFile()) {
            System.out.println(sep + file.getName());
            return;
        }
        //如果是文件夹，打印后，继续后面的循环和判断
        System.out.println(sep + file.getName());
        for (File listFile : file.listFiles()) {
            if (listFile.isDirectory()) {
                //文件夹在这里不打印，在下一次递归函数中再打印，要不然层级不对
                showDirRec(listFile, cnt + 1);
            } else {
                //当前文件夹下的文件要多一级分隔符
                String sep2 = getSep(1);
                System.out.println(sep + sep2 + listFile.getName());
            }
        }
    }

    public static void delDirRec(File file) {
        if (!file.exists()) return;

        if (file.isDirectory()) {
            for (File listFile : file.listFiles()) {
                delDirRec(listFile);
            }
            //删除文件夹本身
            file.delete();
        } else {
            file.delete();
        }
    }
}
