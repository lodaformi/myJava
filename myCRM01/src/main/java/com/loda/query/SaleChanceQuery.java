package com.loda.query;

import com.loda.base.BaseQuery;

/**
 * @Author loda
 * @Date 2022/11/22 19:21
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class SaleChanceQuery extends BaseQuery {
    //pagenation

    //营销机会管理 条件查询condition
    private String customerName; //客户名
    private String createMan;      //创建人
    private Integer state;        //分配状态 0=未分配  1=已分配

    //客户开发计划 条件查询
    private String devResult;    //开发状态
    private Integer assignMan;    //指派人

    public Integer getAssignMan() {
        return assignMan;
    }

    public void setAssignMan(Integer assignMan) {
        this.assignMan = assignMan;
    }



    public SaleChanceQuery() {
    }

    public SaleChanceQuery(String customerName, String createMan, Integer state) {
        this.customerName = customerName;
        this.createMan = createMan;
        this.state = state;
    }

    public String getDevResult() {
        return devResult;
    }

    public void setDevResult(String devResult) {
        this.devResult = devResult;
    }



    /**
     * 获取
     * @return customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 设置
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 获取
     * @return createMan
     */
    public String getCreateMan() {
        return createMan;
    }

    /**
     * 设置
     * @param createMan
     */
    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }

    /**
     * 获取
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    public String toString() {
        return "SaleChanceQuery{customerName = " + customerName + ", createMan = " + createMan + ", state = " + state + "}";
    }
}
