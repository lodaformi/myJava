public class PrintGraph {
    public static void main(String[] args) {
        //下锥三角形
        int width = 9;
//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < width - i; j++) {
//                System.out.print("*\t");
//            }
//            System.out.println();   //换行
//        }

        //等腰三角形
//        for (int i = 0; i < width; i++) {
//            //打印空白
//            for (int j = 0; j < width - i - 1; j++) {
//                System.out.print("\t");
//            }
//            for (int k = 0; k < 2 * i + 1; k++) {
//                System.out.print("*\t");
//            }
//            System.out.println();
//        }

        //菱形
        width = 17;
        int mid = width / 2 + 1;
        System.out.println(mid);
        for (int i = 1; i <= width; i++) {
            //打印上半部分
            if (i <= mid) {
                //打印空白
                for (int j = 1; j <= mid - i; j++) {
                    System.out.print("\t");
                }
                //打印*
                for (int k = 1; k <= 2 * i - 1; k++) {
                    System.out.print("*\t");
                }
                System.out.println();
            } else { // i > mid 打印下半部分
                //打印空白
                for (int j = 1; j <= i - mid; j++) {
                    System.out.print("\t");
                }
                //打印*
                for (int k = 1; k <= (2 * mid - 1) - (2 * (i-mid)); k++) {
//                    System.out.println(((2 * mid - 1) - (2 * k)));
                    System.out.print("*\t");
                }
                System.out.println();
            }
        }
    }
}
