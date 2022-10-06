package com.loda.clone;

public class Student extends Person implements Cloneable{
    private Grade grade;

    public Student() {
    }

    public Student(String name, Integer age, Grade grade) {
        super(name, age);
        this.grade = grade;
    }

    /**
     * 获取
     *
     * @return grade
     */
    public Grade getGrade() {
        return grade;
    }

    /**
     * 设置
     *
     * @param grade
     */
    public void setGrade(Grade grade) {
        this.grade = grade;
    }

//    public String toString() {
//        return "Student{name = " + super.getName() + ", age = " + super.getAge() + " chinese = " +
//                grade.getChinese() + " math = " + grade.getMath() + " eng = " + grade.getEng() + "}";
//    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        Student stuTmp = (Student) super.clone();
        //下面两行有什么区别？？？
//        stuTmp.grade = stuTmp.grade.clone();
        stuTmp.grade = this.grade.clone();
        return stuTmp;
    }
}
