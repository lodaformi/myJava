package com.loda.clone;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student stu01 = new Student("tom", 12, new Grade(10.0, 20.0, 30.0));

        Student stu02 = (Student) stu01.clone();

        System.out.println(stu01);
        System.out.println(stu01.getGrade());
        System.out.println(stu02);
        System.out.println(stu02.getGrade());
    }
}
