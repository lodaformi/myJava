package com.loda.myset.exam;

public class Grade {
    private Double chinese;
    private Double math;
    private Double english;

    public Grade() {
    }

    public Grade(Double chinese, Double math, Double english) {
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    /**
     * 获取
     * @return chinese
     */
    public Double getChinese() {
        return chinese;
    }

    /**
     * 设置
     * @param chinese
     */
    public void setChinese(Double chinese) {
        this.chinese = chinese;
    }

    /**
     * 获取
     * @return math
     */
    public Double getMath() {
        return math;
    }

    /**
     * 设置
     * @param math
     */
    public void setMath(Double math) {
        this.math = math;
    }

    /**
     * 获取
     * @return english
     */
    public Double getEnglish() {
        return english;
    }

    /**
     * 设置
     * @param english
     */
    public void setEnglish(Double english) {
        this.english = english;
    }

    public String toString() {
        return "Grade{chinese = " + chinese + ", math = " + math + ", english = " + english + "}";
    }
}
