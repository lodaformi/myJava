package com.loda.myclone02;

public class Engine implements Cloneable {
    String name;
    String vol;

    public Engine() {
    }

    public Engine(String name, String vol) {
        this.name = name;
        this.vol = vol;
    }

    @Override
    protected Engine clone() throws CloneNotSupportedException {
        return (Engine) super.clone();
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
     * @return vol
     */
    public String getVol() {
        return vol;
    }

    /**
     * 设置
     * @param vol
     */
    public void setVol(String vol) {
        this.vol = vol;
    }

//    public String toString() {
//        return "Engine{name = " + name + ", vol = " + vol + "}";
//    }
}
