package com.loda.entity.vo;

/**
 * @Author loda
 * @Date 2022/11/23 9:04
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class ResultInfo<T> {
    private Integer code;
    private String msg;
    private T obj;

    public ResultInfo() {
    }

    public ResultInfo(Integer code, String msg, T obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    /**
     * 获取
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取
     * @return obj
     */
    public T getObj() {
        return obj;
    }

    /**
     * 设置
     * @param obj
     */
    public void setObj(T obj) {
        this.obj = obj;
    }

    public String toString() {
        return "ResultInfo{code = " + code + ", msg = " + msg + ", obj = " + obj + "}";
    }
}
