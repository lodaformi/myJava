package com.loda.myMap.doudizhu;

import java.util.*;

public class Card {
    private String[] color;
    private String[] num;
    private Map<Integer, String> cMap;
    private List<Integer> cardList;

    public List<Integer> getCardList() {
        return cardList;
    }

    public void setCardList(List<Integer> cardList) {
        this.cardList = cardList;
    }


    public Map<Integer, String> getcMap() {
        return cMap;
    }

    public Card() {
        num = new String[]{"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        color = new String[]{"♥", "♠", "♣", "♦"};
        cMap = new HashMap<>();
        cardList = new ArrayList<>();
    }

    public Card(String[] color, String[] num) {
        this.color = color;
        this.num = num;
    }

    public void cardSet() {
        int i = 0;
        for (String n : num) {
            for (String c : color) {
                cMap.put(i, c + n);
                ++i;
            }
        }
        cMap.put(52, "大王");
        cMap.put(53, "小王");
    }

    public void shuffleCards() {
        for (Integer idx : cMap.keySet()) {
            cardList.add(idx);
        }
        Collections.shuffle(cardList);
    }

    public void dealCard(Player p1, Player p2, Player p3, BottomCard bc) {
        System.out.println("size " + cMap.size());
        for (int i = 0; i < cMap.size(); i++) {
            if (i > 50) {
                bc.getBcSet().add(cardList.get(i));
            } else if (i % 3 == 0) {
                p1.getpSet().add(cardList.get(i));
            } else if (i % 3 == 1) {
                p2.getpSet().add(cardList.get(i));
            } else {
                p3.getpSet().add(cardList.get(i));
            }
        }
    }

    /**
     * 获取
     *
     * @return color
     */
    public String[] getColor() {
        return color;
    }

    /**
     * 设置
     *
     * @param color
     */
    public void setColor(String[] color) {
        this.color = color;
    }

    /**
     * 获取
     *
     * @return num
     */
    public String[] getNum() {
        return num;
    }

    /**
     * 设置
     *
     * @param num
     */
    public void setNum(String[] num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Card{" +
                "color=" + Arrays.toString(color) +
                ", num=" + Arrays.toString(num) +
                ", cardList=" + cardList +
                '}';
    }
}
