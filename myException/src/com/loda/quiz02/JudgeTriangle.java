package com.loda.quiz02;

public class JudgeTriangle {
    public void judgeTriangle(int a, int b, int c) throws TriException {
        if (a + b > c && a + c > b && b + c > a) {
            return;
        }
        throw new TriException(a + ", " + b + ", " + c + "不能构成三角形");
    }
}
