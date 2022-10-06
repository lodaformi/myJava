public class Fibonacci {
    public static void main(String[] args) {
        int num = 40;
        long stTime1 = System.nanoTime();
        System.out.println(FibDG(num));
        long enTime1 = System.nanoTime();
        System.out.println((enTime1-stTime1)/1000 +" us");

        long stTime2 = System.nanoTime();
        System.out.println(FibDGOpt(num));
        long enTime2 = System.nanoTime();
        System.out.println((enTime2-stTime2)/1000 +" us");

        long stTime3 = System.nanoTime();
        System.out.println(FibDD(num));
        long enTime3 = System.nanoTime();
        System.out.println((enTime3-stTime3)/1000 +" us");
    }

    public static long FibDG(int n) {
        //base case
        if (n == 1 || n == 2) {
            return 1;
        }
        // fn = fn-1 + fn-2
        return FibDG(n-1) + FibDG(n-2);
    }

    public static long FibDGOpt(int n) {
        long[] memo = new long[n+1];
        return helper(memo, n);
    }

    public static long helper(long[] memo, int n) {
        //base case
        if (n == 1 || n == 2){
            return 1;
        }
        //如果memo[n]的值不是0，表示已经计算过，直接返回，不再重复计算
        if (memo[n] != 0)  {
            return memo[n];
        }
        //如果memo[n]的值是0，则计算，并保存结果
        memo[n] =  helper(memo,n-1) + helper(memo,n-2);
        //将结果返回
        return memo[n];
    }

    public static long FibDD(int n) {
        long f_2=1, f_1=1, f=0;
        for (int i = 3; i <= n ; i++) {
            f = f_1 + f_2;
            f_2 = f_1;
            f_1 = f;
        }
        return f;
    }
}
