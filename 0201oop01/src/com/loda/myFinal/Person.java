package com.loda.myFinal;

public class Person {
    private String name;
    private int age;
    private char sex;
    private double sal;
    public static final String country = "中国";

    public Person() {
    }

    public Person(String name, int age, char sex, double sal) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.sal = sal;
    }

    public final void show() {
        System.out.println("Person final show");
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return sex
     */
    public char getSex() {
        return sex;
    }

    /**
     * 设置
     * @param sex
     */
    public void setSex(char sex) {
        this.sex = sex;
    }

    /**
     * 获取
     * @return sal
     */
    public double getSal() {
        return sal;
    }

    /**
     * 设置
     * @param sal
     */
    public void setSal(double sal) {
        this.sal = sal;
    }

    public String toString() {
        return "Person{name = " + name + ", age = " + age + ", sex = " + sex + ", sal = " + sal + ", country = " + country + "}";
    }
}
