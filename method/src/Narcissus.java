/**
 * 计算三位数的水仙花数
 */
public class Narcissus {
    public static void main(String[] args) {

        System.out.println(Math.pow(4, 3));
//        calcNarcissus();
        System.out.println(calcX(4563));
//        String str = "empty";
//        // 0相等 1不相等
//        System.out.println(str.compareTo("empt"));
        calcXPowerNum();
    }

    public static void calcNarcissus() {
        int count = 0;
        for (int i = 100; i < 1000; i++) {
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100;
            if (Math.pow(ge, 3) + Math.pow(shi, 3) + Math.pow(bai, 3) == i) {
                System.out.println(i);
                ++count;
            }
        }
        System.out.println("水仙花数有" + count + "个");
    }

    public static String getName(int idx) {
        String[] name = new String[] {"水仙花", "四叶玫瑰", "五角星", "六合", "北斗七星", "八仙"};
        switch (idx) {
            case 3:
                return name[0];
            case 4:
                return name[1];
            case 5:
                return name[2];
            case 6:
                return name[3];
            case 7:
                return name[4];
            case 8:
                return name[5];
        }
        return "empty";
    }


    public static void calcXPowerNum() {
        for (int i = 100; i < 10000; i++) {
            int cnt = calcX(i);
            int sum = 0;
            int k = i;
            while (k > 0) {
                sum += Math.pow(k%10, cnt);
                k /= 10;
            }
            if (sum == i) {
                System.out.println(getName(cnt)+"数: "+ i);
            }
        }
    }

    public static int calcX(int num) {
        int count = 0;
        while (num > 0) {
            ++count;
            num /= 10;
        }
        return count;
    }
}
