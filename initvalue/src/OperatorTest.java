public class OperatorTest {
    public static void main(String[] args) {
        //算术运算符+,-,*,/,% ++ --
//        System.out.println(4/0);
        //赋值运算符 = += -= *= /= %=
        byte a = 3;
        a *= 5;
//        a = a + 5;
        System.out.println(a);
        //比较运算符 == < <= > >= !=
        //逻辑运算符 &&, ||, !, &, |
        //短路效应，后边的表达式不会执行
        System.out.println((3<1) && (4/0 == 0));
        System.out.println((3>1) || (4/0 == 0));

        //没有短路效果
        System.out.println((3>1) & (6>1));
//        System.out.println((3>1) | (4/0 == 0));
        //三目运算符  ? true : false
        System.out.println(3>1 ? "yes" : "no");
    }
}
