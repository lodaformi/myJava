import java.util.Arrays;

public class InDelFind {
    static int[] arr = new int[2];
    static int cnt = 0;

    public static void main(String[] args) {
        for (int i = 5; i > 0; --i) {
            addEle(i);
        }
        printArr();
        insertEle(2, 9);
        printArr();
        Arrays.sort(arr);
        printArr();
        delEle(2);
        printArr();
//        System.out.println(Arrays.toString(arr));
    }

    public static int findEle(int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 删除某个元素，需先找到这个元素的索引
     * 若这个元素不存在，在什么也不做
     * 找到这个索引，将其后的所有元素前移一位
     *
     * @param key
     */
    public static void delEle(int key) {
        int idx = findEle(key);
        if (idx != -1) {
            for (int i = idx; i < cnt - 1; i++) {
                arr[i] = arr[i + 1];    //这里i+1，所以上面i只能取到cnt-2，也就是小于cnt-1
            }
            --cnt;  //删除元素后cnt要减一
        } else {
            System.out.println("元素不存在");
        }
    }

    /**
     * 在idx位置插入key元素，idx位置和之后的所有元素都要后移，给key腾出位置
     * 若没有空间则扩容
     *
     * @param idx 位置
     * @param key 元素
     */
    public static void insertEle(int idx, int key) {
        //先判断容量是否够用
        if (cnt >= arr.length) {
            extendCap();
        }
        //逆序移动idx到cnt之间的所有元素

        for (int i = cnt; i > idx; --i) {
            arr[i] = arr[i - 1];
        }
        arr[idx] = key;
        ++cnt;

//        int i = cnt-1;
//        for (; i >= idx ; --i) {
//            arr[i+1] = arr[i];
//        }
//        arr[++i] = key;
//        ++cnt;
    }


    public static void addEle(int key) {
        if (cnt >= arr.length) {
            extendCap();
        }
        arr[cnt++] = key;
    }

    /**
     * 数组扩容，分4步
     * 计算新数组的长度
     * 申请空间
     * 将旧数组中的值拷贝进新数组
     * 将新数组赋值给旧数组
     */
    public static void extendCap() {
        int newLen = arr.length + (arr.length >> 1);
        int[] newArr = new int[newLen];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public static void printArr() {
        String s = "[";
        for (int i = 0; i < cnt; i++) {
            if (i == cnt - 1) {
                s += (arr[i] + "]");
            } else {
                s += (arr[i] + ",");
            }
//            System.out.print(arr[i]+"\t");
        }
        System.out.println(s);
//        System.out.println();
    }
}
