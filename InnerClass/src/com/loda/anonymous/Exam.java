package com.loda.anonymous;

public class Exam {
    public static void main(String[] args) {
        TestStu.method().study();
    }
}


abstract class Stu {
    public abstract void study();
}

class  TestStu {
    public static Stu method() {
        return new Stu() {
            @Override
            public void study() {
                System.out.println("好好学习，天天向上");
            }
        };
    }
}

