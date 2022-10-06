package com.loda.myInterface;

import com.loda.polymorphism.Kongzi;

public class Laptop {
    public void powerOn(){
        System.out.println("笔记本开机");
    }

    public void powerOff() {
        System.out.println("笔记本关机");
    }

    //接口引用指向实现类对象，也是多态的一种体现
    public void function(USB usb) {
        usb.turnOn();
        if (usb instanceof Mouse) {
            Mouse m = (Mouse) usb;
            m.click();
        }else if (usb instanceof Keyboard){
            Keyboard kb = (Keyboard) usb;
            kb.pressKey();
        }else {
            System.out.println("设备不存在");
        }
        usb.turnOff();
    }
}
