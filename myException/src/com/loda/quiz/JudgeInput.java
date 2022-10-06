package com.loda.quiz;

public class JudgeInput {
    public void judgeInput(int num) throws MyNumException {
        if (num > 10) {
            return;
        }
        throw new MyNumException("请输入大于10的数");
    }
}
