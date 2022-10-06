/**
 * 百鸡百钱
 * 公鸡1只5钱，母鸡1只3钱，小鸡3只1钱，求100钱买100只鸡的方案？
 */
public class HundredChicken {
    public static void main(String[] args) {
        //公鸡最多买20只
        for (int i = 0; i <= 20; i++) {
            //母鸡最多买33只
            for (int j = 0; j <= 33; j++) {
                if ((i * 5 * 3 + j * 3 * 3 + (100 - i - j)) == 3 * 100) {
                    System.out.println("公鸡：" + i + " 母鸡：" + j + " 小鸡：" + (100 - i - j));
                }
            }
        }
    }
}
