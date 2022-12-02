package com.loda.entity.po;

/**
 * @Author loda
 * @Date 2022/11/21 23:16
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class Round {
    private Integer num;

    public Round() {
    }

    public Round(Integer num) {
        this.num = num;
    }

    /**
     * 获取
     * @return num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置
     * @param num
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    public String toString() {
        return "Round{num = " + num + "}";
    }
}
