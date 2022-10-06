public class Array01 {
    public static void main(String[] args) {
        int n = 5;
        //动态初始化
        int[] aList = new int[n];

        //普通for循环
        for (int i = 0; i < aList.length; i++) {
            aList[i] += i * 3;
        }

        System.out.println("++++++++++++++++++++++++++++");
        //静态初始化
        int[] aArr1 = new int[]{4, 2, 7, 19, 110};
        int[] aArr2 = {3,4,5621,3,12,12};
        int[] aArr3;
        aArr3 = new int[] {2,3,12,8};
//        aArr3 = {1,2,3,4,5};
        traverseArr(aArr3);
//        traverseArr(aArr1);
//        traverseArr(aArr2);

    }

    public static void traverseArr(int[] arr) {
        //增强for循环
        for (int e :
                arr) {
            System.out.println(e);
        }
    }
}
