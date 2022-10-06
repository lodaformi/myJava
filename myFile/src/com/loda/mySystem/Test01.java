package com.loda.mySystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("aa.txt"));
        Scanner sc = new Scanner(System.in);
        System.out.print("please input something: ");
        String s = sc.next();
        System.out.println(s);
    }
}
