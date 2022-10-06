package com.loda.charSet;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "国庆节";

        //3个字节编码一个汉字
        byte[] utfByte = str.getBytes("utf8");
        //2个字节编码一个汉字
        byte[] gbkByte = str.getBytes("gbk");

        //编码方式
        System.out.println(Arrays.toString(utfByte));
        System.out.println(Arrays.toString(gbkByte));

        //解码utf
        String getUtf = new String(utfByte, "gbk");
        System.out.println(getUtf);
        getUtf = new String(utfByte, "utf8");
        System.out.println(getUtf);


        //解码gkb
        String getGbk = new String(gbkByte, "utf-8");
        System.out.println(getGbk);
        getGbk = new String(gbkByte, "gbk");
        System.out.println(getGbk);
    }
}
