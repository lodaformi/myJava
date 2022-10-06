package com.loda.generic;

public class Player extends Person{

    public Player() {
    }

    public Player(String name, int age) {
        super(name, age);
    }

    public String toString() {
        return "Player{name = " + super.getName() + ", age = " + super.getName() + "}";
    }
}
