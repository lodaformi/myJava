package com.loda.entity.po;

/**
 * @Author loda
 * @Date 2022/11/21 23:15
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class Stu {
    private Integer id;
    private String name;
    private Integer round;

    public Stu() {
    }

    public Stu(Integer id, String name, Integer round) {
        this.id = id;
        this.name = name;
        this.round = round;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return round
     */
    public Integer getRound() {
        return round;
    }

    /**
     * 设置
     * @param round
     */
    public void setRound(Integer round) {
        this.round = round;
    }

    public String toString() {
        return "Stu{id = " + id + ", name = " + name + ", round = " + round + "}";
    }
}
