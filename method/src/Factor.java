public class Factor {
    public static void main(String[] args) {
        singleNumFactor();
    }

    public static void threeNumFactor() {
        //产生4-89之间的随机数
        int num1 = (int) (Math.random() * (89 - 4 + 1) + 4);
        int num2 = (int) (Math.random() * (89 - 4 + 1) + 4);
        int num3 = (int) (Math.random() * (89 - 4 + 1) + 4);


    }

    public static void singleNumFactor() {
        //产生4-89之间的随机数
        int num = (int) (Math.random() * (89 - 4 + 1) + 4);
        System.out.println(num);
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                System.out.print(i + "\t" + num/i +"\t");
            }
        }
        System.out.println();
    }
}
