package com.loda.customexception;

public class Student {
    private String name;
    private String passwd;


    public Student() {
    }

    public Student(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * 设置
     *
     * @param passwd
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String toString() {
        return "Student{name = " + name + ", passwd = " + passwd + "}";
    }
}
