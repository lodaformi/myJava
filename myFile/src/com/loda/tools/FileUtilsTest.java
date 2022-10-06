package com.loda.tools;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;

import java.io.File;
import java.io.IOException;

public class FileUtilsTest {
    public static void main(String[] args) throws IOException {
        String name = "G:\\msb\\software\\HBuilderProjects\\马士兵线下课程0101Web-32Js练习之猴子摘桃.mp4";
        long size = FileUtils.sizeOf(new File("G:\\msb\\software\\HBuilderProjects\\"));
        System.out.println(size);
        System.out.println(FileUtils.byteCountToDisplaySize(size));

        System.out.println(FileUtils.checksumCRC32(new File(name)));
//
//        System.out.println(FileUtils.isDirectory(new File("aaa")));
//        System.out.println(FileUtils.isEmptyDirectory(new File("aaa")));
//        System.out.println(FileUtils.isRegularFile(new File("aaa/a.txt")));

//        FileUtils.cleanDirectory(new File("aaa"));
        //比较文件内容，文件不存在相等？？
//        System.out.println(FileUtils.contentEquals(new File("aaa/aa.txt"), new  File("aaa/bbb/bb.cpp")));

        //只创建文件夹
//        FileUtils.copyDirectory(new File("G:\\msb\\software\\HBuilderProjects\\"), new File("D:\\abc\\"), DirectoryFileFilter.DIRECTORY);

        //拷贝文件夹时，添加过滤器
//        IOFileFilter htmlFilter = FileFilterUtils.suffixFileFilter(".html");
////        IOFileFilter htmlFiles = FileFilterUtils.andFileFilter(FileFileFilter.FILE, htmlFilter);
//        IOFileFilter htmlFiles = FileFilterUtils.or(DirectoryFileFilter.DIRECTORY, htmlFilter);
//        FileUtils.copyDirectory(new File("G:\\msb\\software\\HBuilderProjects\\"), new File("D:\\abc\\"), htmlFiles);

        //拷贝文件
        //路径不存在时，会自动创建，最好指定文件名，否则会把新创建的最后一级文件夹当成文件名
        // 如果文件夹存在时，没有指定文件名，会报错IllegalArgumentException
//        FileUtils.copyFile(new File("aa.txt"), new File("D:\\www\\a\\b\\c\\d\\bb.txt"));

        //把文件拷贝到一个文件夹中
        //不能指定文件名，若指定文件名，这个文件名会创建成文件夹
        FileUtils.copyFileToDirectory(new File("aa.txt"), new File("d:\\w\\a\\z\\b\\ddd.html"));
    }
}
