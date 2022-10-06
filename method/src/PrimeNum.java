public class PrimeNum {
    public static void main(String[] args) {
        isPrimeNum(2, 999);
    }
    public static void isPrimeNum(int min, int max) {
        int cnt = 0;
        for (int i = min; i <= max; i++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0){
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ++cnt;
//                System.out.println(i+"是质数");
                System.out.print(i+"\t");
                if (cnt % 8 == 0){
                    System.out.println();
                }
            }
        }
    }
}
