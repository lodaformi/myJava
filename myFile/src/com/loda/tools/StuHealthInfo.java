package com.loda.tools;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class StuHealthInfo {
    public static void main(String[] args) throws IOException {
        String[] stuName = new String[]{
                "来宪龙", "王帅", "高艳琪", "张春生", "李联胜",
                "胡涛", "李泽文", "淡一炎", "孙德胜",
                "黎锦沛", "黑海涛", "陈瑶", "万伟锋", "卢永",
                "王锋", "李桁", "刘成龙", "李逢华", "蒋祖禹", "彭江明",
                "屈明", "徐火飞"
        };

        for (String s : stuName) {
            FileUtils.forceMkdir(new File("D:\\StuHealthyInfo" + "\\" + s));
        }

    }
}
