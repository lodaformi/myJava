package com.loda.myclone02;

public class Car implements Cloneable {
    String name;
    String brand;
    Engine engine;

    public Car() {
    }

    public Car(String name, String brand, Engine engine) {
        this.name = name;
        this.brand = brand;
        this.engine = engine;
    }

    @Override
    protected Car clone() throws CloneNotSupportedException {
        Car c = (Car) super.clone();
        c.engine = this.engine.clone();
        return c;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

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
     * @return engine
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * 设置
     * @param engine
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

//    public String toString() {
//        return "Car{name = " + name + ", brand = " + brand + ", engine = " + engine + "}";
//    }
}
