public class TwoDimension {
    public static void main(String[] args) {
        //动态初始化，可以只指定行大小，列大小后面再指定
        int[][] arr = new int[4][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i+1];
        }
//        printArr(arr);
        //动态初始化，指定行和列的大小
        int[][] arr2 = new int[3][5];
//        printArr(arr2);

        //先声明后赋值
        int[][] arr3;
        arr3 = new int[3][];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = new int[i+1];
        }
//        printArr(arr3);

        //
        int[][] arr4;
        arr4 = new int[5][3];
//        printArr(arr4);

        //静态初始化
        int[][] arr5 = {{1,2,4,5},{3},{7,9}};
//        printArr(arr5);

        int[][] arr6 = new int[][]{{1,2,4,5},{3},{7,9}};
//        printArr(arr6);

        int[][] arr7;

//        arr7 = {{1,2,4,5},{3},{7,9}};  //不能这样赋值
        arr7 = new int[][]{{1,2,4,5},{3},{7,9}};
        printArr(arr7);
    }

    public static void printArr(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
    }
}
