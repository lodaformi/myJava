package com.loda.myMap.doudizhu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Player {
    private List pCard;
    private TreeSet<Integer> pSet;

    public void showCards(Map<Integer, String> cardMap) {
        for (Integer integer : pSet) {
            for (Map.Entry<Integer, String> entry : cardMap.entrySet()) {
                if (integer == entry.getKey()) {
                    System.out.print(entry.getValue() + "\t");
                }
            }
        }
        System.out.println();
    }

    public TreeSet<Integer> getpSet() {
        return pSet;
    }

    public void setpSet(TreeSet<Integer> pSet) {
        this.pSet = pSet;
    }

    public List getpCard() {
        return pCard;
    }

    public void setpCard(List pCard) {
        this.pCard = pCard;
    }

    public Player() {
        pCard = new ArrayList();
        pSet = new TreeSet<>();
    }

    public Player(List pCard) {
        this.pCard = pCard;
    }

    /**
     * 获取
     * @return uCard
     */
    public List getUCard() {
        return pCard;
    }

    /**
     * 设置
     * @param uCard
     */
    public void setUCard(List uCard) {
        this.pCard = uCard;
    }

    public String toString() {
        return "User{uCard = " + pCard + "}";
    }
}
