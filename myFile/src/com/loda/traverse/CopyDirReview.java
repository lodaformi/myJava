package com.loda.traverse;

import java.io.*;

public class CopyDirReview {
    public static void main(String[] args) {
        copyDir(new File("G:\\msb\\software\\HBuilderProjects"), new File("G:\\copyDir"));
    }

    public static void copyDir(File srcDir, File dstDir) {
        if (!srcDir.exists()) {
            System.out.println("源文件不存在！");
            return;
        }

        if (!dstDir.exists()) {
            dstDir.mkdir();
        }
        File[] fileList = srcDir.listFiles();
        if (fileList != null && fileList.length != 0) {
            for (File file : fileList) {
                if (file.isDirectory()) {
                    copyDir(file, new File(dstDir+"\\"+file.getName()));
                }else{
                    copyFile(file, new File(dstDir+"\\"+file.getName()));
                }
            }
        }
    }

    public static void copyFile(File srcFile, File dstFile) {
        InputStream in = null;
        OutputStream out = null;
        try {
             in = new FileInputStream(srcFile);
             out = new FileOutputStream(dstFile);
             byte[] by = new byte[1024];
             int len = 0;
             while ((len = in.read(by)) != -1) {
                 out.write(by,0, len);
             }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //流的关闭需要分别处理
                //如果前面的关闭异常，则后面的流不能关闭
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
