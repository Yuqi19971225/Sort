import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int maxSize = 10;
        int maxNum = 100;
        int[] arr1 = generator(maxSize, maxNum);
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        heapSort(arr1);
        Arrays.sort(arr2);
        comparetor(arr1, arr2);
    }

    public static void heapSort(int[] nums) {
        if (nums.length < 2) return;
        for (int i = 0; i < nums.length; ++i) {
            heapInsert(nums, i);
        }
        int heapSize = nums.length;
        swap(nums, 0, --heapSize);
        while (heapSize > 0) {
            heapify(nums, 0, heapSize);
            swap(nums, 0, --heapSize);
        }
    }

    public static void heapInsert(int[] nums, int index) {
        while (nums[index] > nums[(index - 1) / 2]) {
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }

    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            //如果有右孩子，定义一个指针指向其中较大的孩子
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            //将当前数与孩子中较大的进行比较
            largest = arr[index] > arr[largest] ? index : largest;
            //相等说明当前数大于孩子，已经是大根堆了，结束循环
            if (largest == index) break;
            swap(arr, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //数组产生器
    public static int[] generator(int maxSize, int maxNum) {
        int[] arr = new int[maxSize];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (int) (Math.random() * maxNum);
        }
        return arr;
    }

    //比较器
    public static void comparetor(int[] arr1, int[] arr2) {
        boolean ans = true;
        for (int i = 0; i < arr1.length; ++i) {
            if (arr1[i] != arr2[i]) {
                System.out.println("arr1:" + arr1[i] + "  arr2:" + arr2[i]);
                ans = false;
            }
        }
        if (ans) System.out.println("Correct!");
    }
}
