package com.loda.myMap.doudizhu;

import java.util.Map;

public class Doudizhu {
    public static void main(String[] args) {
        Card c = new Card();
        //生成一副扑克牌
        c.cardSet();
        Map<Integer, String> cardMap = c.getcMap();
        System.out.println(c.getcMap());
        //洗牌
        c.shuffleCards();
        System.out.println(c.getCardList());

        //生成3个玩家和1个底牌对象
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        BottomCard bc = new BottomCard();

        //发牌
        c.dealCard(p1, p2, p3, bc);

        //看牌
        p1.showCards(cardMap);
        p2.showCards(cardMap);
        p3.showCards(cardMap);
        bc.showCards(cardMap);
    }


}
