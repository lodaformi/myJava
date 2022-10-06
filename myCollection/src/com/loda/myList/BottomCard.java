package com.loda.myList;

import java.util.ArrayList;
import java.util.List;

public class BottomCard {
    private List bcCard;


    public BottomCard() {
        bcCard = new ArrayList();
    }

    public BottomCard(List bcCard) {
        this.bcCard = bcCard;
    }

    /**
     * 获取
     * @return uCard
     */
    public List getBcCard() {
        return bcCard;
    }

    /**
     * 设置
     * @param uCard
     */
    public void setUCard(List uCard) {
        this.bcCard = uCard;
    }

    public String toString() {
        return "User{uCard = " + bcCard + "}";
    }
}
