public class IfTest01 {
    public static void main(String[] args) {
        //产生173-228之间数
        int a = (int) (Math.random() * (228 - 173 + 1)) + 173;
        int b = (int) (Math.random() * (228 - 173 + 1)) + 173;
        int c = (int) (Math.random() * (228 - 173 + 1)) + 173;
        System.out.println(a + "--" + b + "--" + c);

        if (a > b) {
            if (b > c) {
                System.out.println(a + "--" + b + "--" + c);
            } else if (c > a) {
                System.out.println(c + "--" + a + "--" + b);
            } else {
                System.out.println(a + "--" + c + "--" + b);
            }
        } else {  // b >= a
            if (a > c) {
                System.out.println(b + "--" + a + "--" + c);
            } else if (c > b) {
                System.out.println(c + "--" + b + "--" + a);
            } else {
                System.out.println(b + "--" + c + "--" + a);
            }
        }


        // a中存放较大值，b中存放较小值
        if (a < b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }

        //a最大，c第二
        if (c > a) {
            a = a ^ c;
            c = a ^ c;
            a = a ^ c;
        }

         if (c > b) { // b第二
            b = b ^ c;  // b^c
            c = b ^ c;  // b^c^c  c = b
            b = b ^ c;  // b^c^b  b = c
        }

        System.out.println(a + "--" + b + "--" + c);

    }

}
