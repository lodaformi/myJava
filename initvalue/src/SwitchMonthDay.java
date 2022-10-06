import java.util.Scanner;

public class SwitchMonthDay {
    public static void main(String[] args) {
        System.out.print("请输入年月日：");

        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month =  sc.nextInt();
        int day = sc.nextInt();

        int sumDays = 0;
        //月份只统计到month前一个月
        for (int m = 1; m < month ; m++) {
            switch (m) {
                case 2:
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        sumDays += 29;
                    } else {
                        sumDays += 28;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    sumDays += 30;
                default:
                    sumDays += 31;
            }
        }
        sumDays += day;
        System.out.println("这是今年的第"+sumDays+"天");
    }
}
