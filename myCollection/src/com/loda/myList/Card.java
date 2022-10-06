package com.loda.myList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {
    private String[] color;
    private String[] num;
    private List cards;

    public List getCards() {
        return cards;
    }

    public void setCards(List cards) {
        this.cards = cards;
    }

    public Card() {
        color = new String[]{"♥", "♠", "♣", "♦"};
        num = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        cards = new ArrayList();
    }

    public Card(String[] color, String[] num) {
        this.color = color;
        this.num = num;
    }

    public void cardSet() {
        for (String c : color) {
            for (String n : num) {
                cards.add(c + n);
            }
        }
        cards.add("大王");
        cards.add("小王");
    }

    public void shuffleCards() {
        Collections.shuffle(cards);
    }

    public void dealCard(User p1, User p2, User p3, BottomCard bc) {
        System.out.println("size "+cards.size());
        for (int i = 0; i < cards.size(); i++) {
            if (i > 50) {
                bc.getBcCard().add(cards.get(i));
            }else if(i % 3 == 0 ) {
                p1.getUCard().add(cards.get(i));
            }else if (i % 3 == 1) {
                p2.getUCard().add(cards.get(i + 1));
            }else {
                p3.getUCard().add(cards.get(i + 2));
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
                "cards=" + cards +
                '}';
    }
}
