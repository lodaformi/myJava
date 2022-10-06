package com.loda.customexception;

import java.text.NumberFormat;
import java.util.Scanner;

public class LoginTest {
    public static void main(String[] args) throws StuException {
        Login ll = null;
        ll.loginCheck("tom","123");
//        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.print("please input your name: ");
        String name = sc.next();
        System.out.print("please input your password: ");
        String pwd = sc.next();

        Login lg = new Login();
        try {
            Student stu = lg.loginCheck(name, pwd);
            System.out.println("login successfully!");
        } catch (StuException e) {
            System.out.println(e.getMessage());
        }
    }
}
