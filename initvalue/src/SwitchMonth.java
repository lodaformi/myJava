import java.util.Scanner;

/**
 * 判断每月的天数
 * 需考虑大小月份和2月份(平闰年)
 */
public class SwitchMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("please input month: ");
        int month =  sc.nextInt();

        switch (month) {
            //合理利用case穿透
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(month+"有30天");
                break;
            case 2:
                System.out.print("please input year: ");
                int year = sc.nextInt();
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    System.out.println(year+"年"+month+"有29天");
                }else{
                    System.out.println(year+"年"+month+"有28天");
                }
                break;
            default:
                System.out.println(month+"有31天");
        }

        //计算某一天是今年的多少天

    }
}
