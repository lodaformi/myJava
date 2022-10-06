package com.loda.mystatic;

public class HPLaptop extends Computer{
    String color;
    HPLaptop() {
    }

    @Override
    public String toString() {
        return "HPLaptop{" +
                "brand=" + super.getBrand() +
                "price=" + super.getPrice() +
                "type=" + super.isType() +
                "color='" + color + '\'' +
                '}';
    }

}
