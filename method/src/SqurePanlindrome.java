public class SqurePanlindrome {
    public static void main(String[] args) {
//        String s1 = "he";
//        System.out.println(s1.getClass().toString());
//        System.out.println(Math.sqrt(121) == 11);
//        System.out.println(Math.sqrt(122));
//        System.out.println(1.2 == 1.2);
        judgeSqurePanlindrome();
    }

    public static void judgeSqurePanlindrome() {
        for (int i = 100; i < 1000; i++) {
            int ai = 0;
            int k = i;
            while (k > 0) {
                ai = ai * 10 + k % 10;
                k /= 10;
            }

            if (ai == i) {
                for (int j = 1; j <= Math.sqrt(i); j++) {
                    if (Math.pow(j, 2) == i) {
                        System.out.println(i + "是" + j + "的平方回文数");
                    }
                }
            }
        }
    }
}
