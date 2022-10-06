public class Palindrome {
    public static void main(String[] args) {
        judgePalindrome();
    }

    public static void judgePalindrome() {
        int t = 0;
        int count = 0;
        for (int i = 1; i <= 1000; i++) {
            int k = i;
            t = 0;
            count = 0;
            while (k > 0) {
                ++count;
                //使用t记录逐步反转之后的和
                //乘以10(相当于t每次扩大10倍，有几位就扩大几个10倍)，加上本次数值最后一位(取余)
                t = t * 10 + k % 10;
                //数值除10，获取到本次余数之前的数值
                k = k / 10;
            }
            if (t == i) {
                System.out.println(i + " 是回文数 "+count+" 位数");
            }
        }
    }
}
