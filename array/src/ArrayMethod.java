import java.util.Arrays;

public class ArrayMethod {
    public static void main(String[] args) {
        int[] arr = {3, 2, 7, 9, 8, 3};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr, 7));

        reverseArr(arr);
        System.out.println(Arrays.toString(arr));
    }





    /**
     * 二分查找，返回ele的索引，如果ele不存在，返回-1
     * @param arr
     * @param ele
     */
    public static int binarySearch(int[] arr, int ele) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 2);
            if (arr[mid] == ele) {
                return mid;
            } else if (arr[mid] < ele) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 反转数组
     * @param arr
     */
    public static void reverseArr(int[] arr) {
        int start = 0;
        int end= arr.length-1;
        while (start < end) {
            swap(arr,start, end);
            ++start;
            --end;
        }
    }

    public static void swap(int[] arr, int id1, int id2) {
        int tmp = arr[id1];
        arr[id1] = arr[id2];
        arr[id2] = tmp;
    }
}
