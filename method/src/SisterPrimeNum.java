public class SisterPrimeNum {
    public static void main(String[] args) {
        sisterPrime(2,999);
    }

    public static void  sisterPrime(int min, int max) {
        int prePrime = 2;
        for (int i = min; i <= max; i++) {
            if (isPrime(i)) {
                if ((i - prePrime) == 2) {
                    System.out.println(prePrime+"和"+i+"是姐妹质数");
                }

                //更新变量
                prePrime = i;
            }

        }
    }

    public static boolean isPrime(int num) {
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        return  flag;
    }
}
