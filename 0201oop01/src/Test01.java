public class Test01 {
    public static void main(String[] args) {
        CarTest ct = new CarTest("white", 4);
        ct.show();

        ct.crash();
        ct.show();

        Maintenance mt = new Maintenance();
        mt.op(ct);
        ct.show();
    }
}

class CarTest {
    String color;
    int wheelNum;

    CarTest(String c, int w) {
        color = c;
        wheelNum = w;
    }

    public void crash() {
        System.out.println("发生车祸");
        wheelNum -= 1;
    }

    public void show() {
        System.out.println("车的颜色："+color+"\t轮子数："+wheelNum);
    }
}

class Maintenance {
    public void op(CarTest ct) {
        ct.wheelNum = 4;
        ct.color = "red";
    }
}