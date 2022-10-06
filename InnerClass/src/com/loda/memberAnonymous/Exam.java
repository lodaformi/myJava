package com.loda.memberAnonymous;

public class Exam {
    public static void main(String[] args) {
        Outer.Inner oi = new Outer().new Inner();
        oi.show();
    }
}

class Outer {
    int i = 10;
    class Inner {
        int i = 20;
        public void show() {
            int i = 30;
            System.out.println(i);
            System.out.println(this.i);
            System.out.println(Outer.this.i);
        }
    }
}