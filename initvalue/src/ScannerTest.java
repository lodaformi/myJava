import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        int age;
        byte sex;
        System.out.println("请输入姓名：");
        name = sc.next();
        System.out.println("请输入年龄：");
        age = sc.nextInt();
        System.out.println("请输入性别：");
        sex = sc.nextByte();

        System.out.println("姓名：" + name + "\n年龄：" + age + "\n性别：" + sex);
    }
}
