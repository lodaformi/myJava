package com.loda.myMap.doudizhu;

import java.util.*;

public class BottomCard {
    private List bcCard;
    private Set<Integer> bcSet;


    public void showCards(Map<Integer, String> cardMap) {
        for (Integer integer : bcSet) {
            for (Map.Entry<Integer, String> entry : cardMap.entrySet()) {
                if (integer == entry.getKey()) {
                    System.out.print(entry.getValue() + "\t");
                }
            }
        }
        System.out.println();
    }

    public Set<Integer> getBcSet() {
        return bcSet;
    }

    public void setBcSet(Set<Integer> bcSet) {
        this.bcSet = bcSet;
    }


    public BottomCard() {
        bcCard = new ArrayList();
        bcSet = new TreeSet();
    }

    public BottomCard(List bcCard) {
        this.bcCard = bcCard;
    }

    /**
     * 获取
     *
     * @return uCard
     */
    public List getBcCard() {
        return bcCard;
    }

    /**
     * 设置
     *
     * @param uCard
     */
    public void setUCard(List uCard) {
        this.bcCard = uCard;
    }

    public String toString() {
        return "User{uCard = " + bcCard + "}";
    }
}
