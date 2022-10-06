package com.loda.clone;

public class Grade implements Cloneable{
    private Double chinese;
    private Double math;
    private Double eng;

    public Grade() {
    }

    public Grade(Double chinese, Double math, Double eng) {
        this.chinese = chinese;
        this.math = math;
        this.eng = eng;
    }

    @Override
    protected Grade clone() throws CloneNotSupportedException {
        return (Grade) super.clone();
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
     * @return eng
     */
    public Double getEng() {
        return eng;
    }

    /**
     * 设置
     * @param eng
     */
    public void setEng(Double eng) {
        this.eng = eng;
    }

//    public String toString() {
//        return "Grade{chinese = " + chinese + ", math = " + math + ", eng = " + eng + "}";
//    }
}
