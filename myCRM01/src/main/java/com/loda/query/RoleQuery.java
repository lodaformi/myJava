package com.loda.query;

import com.loda.base.BaseQuery;

/**
 * @Author loda
 * @Date 2022/11/28 14:56
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class RoleQuery extends BaseQuery {
    private String roleName;    //角色名称

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
