package com.loda.mystatic;

import java.util.Objects;

public class Computer {
    private String brand;
    private double price;
    private boolean type;   //laptop or pc
//    public static int year;

    public Computer() {
        System.out.println("constructor without argument");
    }
    //    static {
//        System.out.println("static code block");
//        System.out.println(year);
//        year = 2029;
//        System.out.println(year);
//    }
//    {
//        System.out.println("constuctor code block");
//    }
    public Computer(String brand, double price, boolean type) {
        this.brand = brand;
        this.price = price;
        this.type = type;
        System.out.println("constructor with 3 argument");
    }

//    public static void show() {
//        System.out.println("static show");
//        System.out.println(year);
//    }
    /**
     * 获取
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 获取
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 获取
     * @return type
     */
    public boolean isType() {
        return type;
    }

    /**
     * 设置
     * @param type
     */
    public void setType(boolean type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Computer{brand = " + brand + ", price = " + price + ", type = " + type + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Computer)) return false;
        Computer computer = (Computer) o;
        return Double.compare(computer.price, price) == 0 && type == computer.type && brand.equals(computer.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, price, type);
    }
}
