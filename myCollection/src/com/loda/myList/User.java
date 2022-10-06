package com.loda.myList;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List uCard;

    public User() {
        uCard = new ArrayList();
    }

    public User(List uCard) {
        this.uCard = uCard;
    }

    /**
     * 获取
     * @return uCard
     */
    public List getUCard() {
        return uCard;
    }

    /**
     * 设置
     * @param uCard
     */
    public void setUCard(List uCard) {
        this.uCard = uCard;
    }

    public String toString() {
        return "User{uCard = " + uCard + "}";
    }
}
