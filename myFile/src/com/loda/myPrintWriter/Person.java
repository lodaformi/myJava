package com.loda.myPrintWriter;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 123141235135L;
    private String name;
    private Integer age;
    private String address;
    private transient Double sal;
    private static Integer grade;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", sal=" + sal +
                '}';
    }

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
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
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Person)) return false;
//        Person person = (Person) o;
//        return Objects.equals(name, person.name) && Objects.equals(age, person.age) && Objects.equals(address, person.address) && Objects.equals(sal, person.sal);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age, address, sal);
//    }
}
