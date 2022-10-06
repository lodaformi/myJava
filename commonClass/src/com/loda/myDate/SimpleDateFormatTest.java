package com.loda.myDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {
        Date date = new Date(0L);
        System.out.println(date);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat dateFormat2 = new SimpleDateFormat();

        String dateStr = dateFormat.format(date);
        System.out.println(dateStr);
        System.out.println(dateFormat2.format(date));
        System.out.println(DateFormat.getInstance().format(date));
        System.out.println("--------------");

        Date date1 = dateFormat.parse("2022-10-04 16:35:25");
        System.out.println(date1);
        System.out.println(date1.getTime());


        String s = "he-lloheworlhed";
        String[] sArr = s.split("he");
        System.out.println(Arrays.toString(sArr));
        System.out.println(sArr.length);
        System.out.println(sArr[0] == "");
//        for (int i = 0; i < sArr.length; i++) {
//            System.out.print(sArr[i] + "\t");
//        }
//        System.out.println();
        //反转字符串
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >=0 ; --i) {
            sb.append(s.charAt(i));
        }
        System.out.println(sb);
    }
}
