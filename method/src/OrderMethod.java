public class OrderMethod {
    static int[] arr = {4, 2, 1, 8, 3};
    static int[] copyArr = new int[arr.length];

    public static void main(String[] args) {

//        selectSearch(arr);
//        bubbleSort(arr);
//        insertSort(arr);
        mergeSort(arr,0,arr.length-1);
        printArr(arr);
        System.out.println();
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static void selectSearch(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { //n个数n-1趟
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }
            swap(arr, minIdx, i);
//            arr[i] = arr[i] ^ arr[minIdx];            // a = a^b
//            arr[minIdx] = arr[i] ^ arr[minIdx];       // b = a^b  a^b^b  b=a
//            arr[i] = arr[i] ^ arr[minIdx];            // a = a^b  a^b^a  a=b
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; --i) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
//                    arr[j] = arr[j] ^ arr[j + 1];
//                    arr[j + 1] = arr[j] ^ arr[j + 1];
//                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    arr[j] = arr[j] ^ arr[j + 1];
//                    arr[j + 1] = arr[j] ^ arr[j + 1];
//                    arr[j] = arr[j] ^ arr[j + 1];
//                }
//            }
//        }
    }


    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int j = i, tmp = arr[i];
            for (; j > 0 && arr[j - 1] > tmp; --j) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    //二叉树后续遍历


    public static void mergeSort(int arr[], int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    public static void merge(int arr[], int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            copyArr[i] = arr[i];
        }
        int idx = left;
        int leftIdx = left;
        int rightIdx = mid + 1;
        while (idx <= right) {
            if (rightIdx > right || leftIdx <= mid && copyArr[leftIdx] < copyArr[rightIdx]) {
                arr[idx++] = copyArr[leftIdx++];
            } else {
                arr[idx++] = copyArr[rightIdx++];
            }
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
