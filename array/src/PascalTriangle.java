import java.util.Arrays;

public class PascalTriangle {

    public static void main(String[] args) {
//        int[][] arr = new int[3][5];
//        for (int[] ints : arr) {
//            for (int anInt : ints) {
//                System.out.print("长度：" + ints.length + "--" + anInt + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println(Arrays.toString(arr));
//        System.out.println(arr.length);
        pascalTriangle();
    }

    public static void pascalTriangle() {
        int[][] triangle = new int[11][];
        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[(i + 1)];
        }

        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][0] = 1;
                triangle[i][i] = 1;
            }
        }

        //从索引为2的地方开始
        for (int i = 2; i < triangle.length; i++) {
            //第一列和最后一列不用处理
            for (int j = 1; j < triangle[i].length - 1; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        printArr(triangle);
    }

    public static void printArr(int[][] arr) {
        int totLen = arr.length;
        for (int i = 0; i < arr.length; i++) {
            String s = "";
            for (int x = 0; x < ((totLen - arr[i].length)>>1); x++) {
                s += "\t";
             }
            System.out.print(s);
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }


//        for (int[] ints : arr) {
//            for (int i = 0; i < totLen - ints.length; i++) {
//                s += " ";
//            }
//
//            System.out.print(s);
//            for (int anInt : ints) {
//                System.out.print(anInt + "\t");
//            }
//            System.out.println();
//        }
    }
}
