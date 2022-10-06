package com.loda.myset.exam;

public class Student implements Comparable<Student> {
    private String name;
    private Integer age;
    private Character sex;
    private Grade grade;

    public Student() {
    }

    public Student(String name, Integer age, Character sex, Grade grade) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.grade = grade;
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
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取
     *
     * @return sex
     */
    public Character getSex() {
        return sex;
    }

    /**
     * 设置
     *
     * @param sex
     */
    public void setSex(Character sex) {
        this.sex = sex;
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

    public String toString() {
        return "Student{name = " + name + ", age = " + age + ", sex = " + sex + ", grade = " + grade + "}";
    }

    public Double getScore(Student stu) {
        return stu.grade.getChinese() + stu.grade.getMath() + stu.grade.getEnglish();
    }

    @Override
    public int compareTo(Student stu) {
        Double score1 = getScore(this);
        Double score2 = getScore(stu);

        double res = score1 - score2;
        if (score1 == score2) { //如果总分相同，比较语文分数
            res = this.grade.getChinese() - stu.grade.getChinese();
            if (res == 0) { //如果语文分数相同，比较数学分数
                res = this.grade.getMath() - stu.grade.getMath();
                if (res == 0) { //如果数学分数相同，比较年龄
                    res = (int) (this.age - stu.age);
                    if (res == 0) { //如果年龄相同，比较姓名
                        res = this.name.compareTo(stu.name);
                        return (int) res;
                    }
                    return (int) res;
                }
                return (int) res;
            }
            return (int) res;
        }
        //如果总分不同
        return (int) res;
    }
}
