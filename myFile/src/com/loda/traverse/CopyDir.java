package com.loda.traverse;

import java.io.*;

public class CopyDir {
    public void copyDir(File srcDir, File dstDir) {
        if (!dstDir.exists()) {
            dstDir.mkdir();
        }

        File[] fList = srcDir.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                copyFile(file, new File(dstDir + "\\" + file.getName()));
            } else {
                copyDir(file, new File(dstDir + "\\" + file.getName()));
            }
        }
    }

    public void copyFile(File srcFile, File dstFile) {
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(srcFile);
            os = new FileOutputStream(dstFile);

            byte[] by = new byte[1024];
            int len = 0;
            while ((len = is.read(by)) != -1) {
                os.write(by, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
