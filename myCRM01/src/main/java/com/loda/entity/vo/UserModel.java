package com.loda.entity.vo;

/**
 * @Author loda
 * @Date 2022/11/21 16:59
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class UserModel {
//    private Integer id;
    private String idStr;
    private String userName;
    private String trueName;


    public UserModel() {
    }

    public UserModel(String idStr, String userName, String trueName) {
        this.idStr = idStr;
        this.userName = userName;
        this.trueName = trueName;
    }

    /**
     * 获取
     * @return idStr
     */
    public String getIdStr() {
        return idStr;
    }

    /**
     * 设置
     * @param idStr
     */
    public void setIdStr(String idStr) {
        this.idStr = idStr;
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
     * @return trueName
     */
    public String getTrueName() {
        return trueName;
    }

    /**
     * 设置
     * @param trueName
     */
    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String toString() {
        return "UserModel{idStr = " + idStr + ", userName = " + userName + ", trueName = " + trueName + "}";
    }
}
