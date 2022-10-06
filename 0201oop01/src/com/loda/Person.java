package com.loda;

public class Person {
    private String name;
    private double age;
    private char sex;

    public Person() {
    }

    public Person(String name, double age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        age = age > 150 || age <0 ? 18 : age;
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        sex = sex != '男' || sex != '女' ? '男' : sex;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
