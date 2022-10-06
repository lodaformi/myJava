public class RandTest {
    public static void main(String[] args) {
        //产生[23, 31]之间的随机数
        int ran;
        for (int i = 0; i < 150 ; i++) {
            ran = (int)(Math.random()*(31-23+1) + 23);
            System.out.println(ran + " ");
        }
        System.out.println("\n");
    }
}
