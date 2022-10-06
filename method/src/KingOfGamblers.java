public class KingOfGamblers {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            kGamblers();
        }
    }

    public static void kGamblers() {
        int a = (int) (Math.random() * 6) + 1;
        int b = (int) (Math.random() * 6) + 1;
        int c = (int) (Math.random() * 6) + 1;
        System.out.println(a + "--" + b + "--" + c);

        if (a == b && a == c) {
            System.out.println("豹子");
        } else if (a == b || a == c || b == c) {
            System.out.println("双");
        } else if ((a-b)*(b-c) == 1) {
            System.out.println("自然顺子");
        } else if((a-b)*(b-c) == -2) {
            System.out.println("间隔顺子");
        }else {
            System.out.println("单");
        }
    }
    // 234 432  乘积绝对值1
    // 243 423 324 342 乘积绝对值2
    //

    // 653 反例 561
    // 234 243
    // 324 342
    // 423 432
}
