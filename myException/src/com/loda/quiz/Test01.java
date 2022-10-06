package com.loda.quiz;

/*
从键盘输入一个整形数n，如果输入正确的话，输出10-n后的值，
如果输入错误的话输出“not int”,
如果输入的不是整数，则抛出异常类：InputMismatchException。

//使用scanner获取输入数据，数据的类型在使用其方法时就已经指定了，
获取数据还有别的方式吗？
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        JudgeInput ji = new JudgeInput();
        System.out.print("please input a num: ");
        try {
            int inputNum = sc.nextInt();
            ji.judgeInput(inputNum);
            for (int i = 10; i <= inputNum ; i++) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }catch (InputMismatchException e) {
            System.out.println("not int");
            throw new InputMismatchException("");
        }
        catch (MyNumException e) {
            System.out.println(e.getMessage());
        }

    }

}
