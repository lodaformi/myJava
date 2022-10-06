import java.util.Scanner;

/**
 * 模拟日历
 * 1900年1月1日 星期一
 */
public class CalendarTest {
    public static void main(String[] args) {
        System.out.println("请输入年月");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();

        int totDay = 0;
        //算出1900到year之前的年共计有多少天
        totDay += calcYearDays(year);

        //算出year这一年month之前月有多少天
        totDay += calcMonthDays(year, month);

        //本月有多少天
        int curMonDay = monthDay(year, month);

        //算出总天数有多少个7天，不能整除时，下个月从 “取模到的天数” 后面开始计数
        int space = totDay % 7;

        //打印每月的表头，从周一开始
        System.out.println("一\t二\t三\t四\t五\t六\t日");
        //打印空格
        for (int i = 0; i < space; i++) {
            System.out.print("\t");
        }
        //打印当前月
        for (int i = 1; i <= curMonDay; i++) {
            System.out.print(i + "\t");
            //当为7的倍数时换行
            if ((space + i) % 7 == 0) {
                System.out.println();
            }
        }
    }

    public static  int calcMonthDays(int year, int month) {
        int sumDays = 0;
        for (int i = 1; i < month; i++) {
            sumDays += monthDay(year,i);
        }
        return sumDays;
    }

    public static int calcYearDays(int year) {
        int sumDays = 0;
        for (int i = 1900; i < year; i++) {
            sumDays +=  isLeapYear(i) ?  366 : 365;
        }
        return  sumDays;
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int monthDay(int year, int month) {
        int days = 0;
        switch (month) {
            case 2:
                if (isLeapYear(year)) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            default:
                days = 31;
        }
        return days;
    }
}
