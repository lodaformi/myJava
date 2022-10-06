import java.util.Arrays;

public class SortMethod {
    public static void main(String[] args) {

        int[] arr = {3, 2, 7, 9, 1, 3};
//        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//        bubbleSort1(arr);
//        bubbleSort2(arr);
//        selectSearch(arr);
        insertSearch(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort1(int[] arr) {
        for (int i = arr.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
            System.out.println("第" + (arr.length - i) + "轮的结果是:" + Arrays.toString(arr));
        }
    }

    public static void bubbleSort2(int[] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                    ++cnt;
                }
            }
            if (cnt == 0) {
                System.out.println("第" + (i + 1) + "轮的结果是:" + Arrays.toString(arr));
                break;
            }
            if (!flag) {
                break;
            }
            System.out.println("第" + (i + 1) + "轮的结果是:" + Arrays.toString(arr));
        }
    }

    public static void selectSearch(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }

    public static void insertSearch(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int j = i, tmp = arr[i];
            for (; j > 0 && tmp < arr[j - 1]; --j) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    public static void swap(int[] arr, int id1, int id2) {
        int tmp = arr[id1];
        arr[id1] = arr[id2];
        arr[id2] = tmp;
    }
}
