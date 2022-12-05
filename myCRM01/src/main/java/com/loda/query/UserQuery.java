package com.loda.query;

import com.loda.base.BaseQuery;

/**
 * @Author loda
 * @Date 2022/11/26 15:13
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class UserQuery extends BaseQuery {
    private String userName;
    private String email;
    private String phone;

    public UserQuery() {
    }

    public UserQuery(String userName, String email, String phone) {
        this.userName = userName;
        this.email = email;
        this.phone = phone;
    }

    /**
     * 获取
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "UserQuery{userName = " + userName + ", email = " + email + ", phone = " + phone + "}";
    }
}
