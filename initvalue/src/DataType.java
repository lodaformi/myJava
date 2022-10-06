public class DataType {
    public static void main(String[] args) {
        byte b1 = 23;
        // 5为int类型，与b1运算又转为byte，可能会发生精度丢失，
//        b1 = b1 + 5;
        b1 = (byte) (b1 + 5);
        System.out.println(b1);

        byte b2 = (byte) 257;
        System.out.println(b2);

        short aa1 = 2;
        short aa2 = 4;
        // byte, short, char运算之前都会提升为int
//        short aa3 = aa1 + aa2;
        char c1 = 48;
        char c2 = 65;
//        char c3 = c1 + c2;

        //ASCII: American Standard Code for Information Interchange
        //美国信息交换标准码
        // 0, A, a
        char cc1 = 48, cc2 = 65, cc3 = 97;
        System.out.println(cc1);
        System.out.println(cc2);
        System.out.println(cc3);
    }
}
