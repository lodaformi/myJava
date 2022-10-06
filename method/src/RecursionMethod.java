import java.sql.Array;

public class RecursionMethod {
    public static void main(String[] args) throws InterruptedException {
        int num = 20;
        //秒 毫秒 微秒 纳秒
//        System.out.println(factorial(5));
        long stTime1 = System.nanoTime();
        System.out.println("rabbits "+rabbit(num));
//        Thread.sleep(1000);
        long enTime1 = System.nanoTime();
        System.out.println((enTime1 - stTime1)/1000.0+"微秒");

        long stTime2 = System.nanoTime();
        System.out.println("rabbits "+ rabbitOpt(num));
        long enTime2 = System.nanoTime();
        System.out.println((enTime2 - stTime2)/1000.0+"微秒");

        long stTime3 = System.nanoTime();
        System.out.println("rabbits "+rabbitDD(num));
        long enTime3 = System.nanoTime();
        System.out.println((enTime3 - stTime3)/1000.0+"微秒");
    }

    //阶乘
    public static long factorial(long n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }


    //不死兔递归实现
    public static long rabbit(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return rabbit(n - 1) + rabbit(n - 2);
    }

    //不死兔递归实现优化，加上备忘录
    public static long rabbitOpt(int n) {
        long[] memo = new long[n + 1];
        return helper(memo, n);
    }

    public static long helper(long[] memo, int n) {
        //base case
        if (n == 1 || n == 2) {
            return 1;
        }
        //先查记录，有就使用记录
        if (memo[n] != 0) return memo[n];

        //没有记录，将计算结果存入备忘录
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        //将结果返回
        return memo[n];
    }

    //不死兔迭代实现
    public static long rabbitDD(int n) {
        long f_2 = 1, f_1 = 1, f = 0;
        for (int i = 3; i <= n; i++) {
            f = f_1 + f_2;
            f_2 = f_1;
            f_1 = f;
        }
        return f;
    }
}
