package com.loda.deadlock;

public class Test {
    public static void main(String[] args) {
        Object remote = new Object();
        Object battery = new Object();

        Player1 p1 = new Player1("player1", remote, battery);
        Player2 p2 = new Player2("player2", remote, battery);

        p1.start();
        p2.start();
    }

}
