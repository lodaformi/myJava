import java.util.Scanner;

/**
 * 每周运动和休息
 */
public class SwitchWeek {
    public static void main(String[] args) {
        System.out.print("please input one day: ");
        int week = new Scanner(System.in).nextInt();
        switch (week) {
            case 1:
                System.out.println("跑步");
                break;
            case 3:
                System.out.println("打篮球");
                break;
            case 5:
                System.out.println("游泳");
                break;
            case 2:
            case 4:
            case 6:
            case 7:
                System.out.println("休息");
                break;
            default:
                System.out.println("输入错误");
                break;
        }
    }
}
