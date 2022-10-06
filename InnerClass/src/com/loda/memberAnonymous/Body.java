package com.loda.memberAnonymous;

public class Body {
    private boolean isAlive;

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    class Heart {
        private int i = 100;
        public void show() {
            System.out.println(i);
        }
        public void heardBeat() {
            if (isAlive()) {
                System.out.println("活人");
            }else   {
                System.out.println("死人");
            }
        }
    }

    public void show() {
        System.out.println(new Heart().i);
    }
}
