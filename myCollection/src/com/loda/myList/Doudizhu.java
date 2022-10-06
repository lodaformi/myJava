package com.loda.myList;

public class Doudizhu {
    public static void main(String[] args) {
        Card c = new Card();
        //生成一副扑克牌
        c.cardSet();
        System.out.println(c.getCards());
        //洗牌
        c.shuffleCards();
        System.out.println(c.getCards());

        //生成3个玩家和1个底牌对象
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        BottomCard bc = new BottomCard();

        //发牌
        c.dealCard(u1,u2,u3,bc);

        //看牌
        System.out.println(u1.getUCard());
        System.out.println(u2.getUCard());
        System.out.println(u3.getUCard());
        System.out.println(bc.getBcCard());
    }


}
