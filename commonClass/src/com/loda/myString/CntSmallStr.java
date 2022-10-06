package com.loda.myString;

public class CntSmallStr {
    public static void main(String[] args) {
        String str = "sjavajavafasfdjavaasfgdagdwt3q1java346435ujavacb sdzfbr65yu73e56javaiu3e243wftg";

        calcCnt1(str,"java");
        calcCnt2(str,"java");
        calcCnt3(str,"java");

    }

    public static void calcCnt1(String bigStr, String smallStr){
        int idx = 0;
        int cnt = 0;
        //查找smallStr第一次出现的位置，找到后idx不为-1，则计数加一，当idx为-1时，则退出循环
        //更新idx，每次从idx处往后查找
        while ((idx = bigStr.indexOf(smallStr, idx)) != -1) {
            ++cnt;
            idx += smallStr.length();
        }
        System.out.println(cnt);
    }

    public static void calcCnt2(String bigStr, String smallStr){
        int idx = 0;
        int cnt = 0;
        //查找smallStr第一次出现的位置，找到后idx不为-1，则计数加一，当idx为-1时，则退出循环
        //截取更新bigStr，从idx+smallStr的长度处截取到bigStr末尾
        while ((idx = bigStr.indexOf(smallStr)) != -1) {
            ++cnt;
            bigStr = bigStr.substring(idx+smallStr.length());
        }
        System.out.println(cnt);
    }
    public static void calcCnt3(String bigStr, String smallStr){
        //以smallStr分割bigStr，会得到一个数组，数组的长度减一，就是smallStr出现的个数
        System.out.println(bigStr.split(smallStr).length-1);
    }
}
