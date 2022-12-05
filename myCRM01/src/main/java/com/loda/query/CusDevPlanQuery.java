package com.loda.query;

import com.loda.base.BaseQuery;

/**
 * @Author loda
 * @Date 2022/11/25 15:33
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class CusDevPlanQuery extends BaseQuery {
    private Integer saleChanceId;   //营销机会的主键

    public Integer getSaleChanceId() {
        return saleChanceId;
    }

    public void setSaleChanceId(Integer saleChanceId) {
        this.saleChanceId = saleChanceId;
    }
}
