package com.loda.quiz02;

import com.loda.quiz.JudgeInput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
写一个方法void triangle(int a,int b,int c)，判断三个参数是否能构成一个三角形。
如果不能则抛出异常IllegalArgumentException，显示异常信息：“a,b,c不能构成三角形”；
如果可以构成则显示三角形三个边长。
在主方法中得到命令行输入的三个整数，调用此方法，并捕获异常。
例:
输入输出说明:
2 4 3
三角形的三边长为：2,4,3
1 2 3
1,2,3不能构成三角形

1 2.0 3
请输入整数作为三角形的边长

如何判断三个数能否构成一个三角形？
    任意两边之合大于第三边
 */
public class Test {
    public static void main(String[] args) throws IllegalArgumentException {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入3个数：");
        int a = 0, b = 0, c = 0;
        JudgeTriangle jt = new JudgeTriangle();

        try {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            jt.judgeTriangle(a, b, c);
            System.out.println("三角形的三边长为：" + a + ", " + b + ", " + c);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        } catch (TriException e) {
            System.out.println(e.getMessage());
        }
    }
}
