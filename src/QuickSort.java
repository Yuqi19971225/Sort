import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int maxSize = 10;
        int maxNum = 100;
        int[] arr1 = generator(maxSize, maxNum);
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        quickSort(arr1, 0, arr1.length - 1);
        Arrays.sort(arr2);
        comparetor(arr1, arr2);
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            //随机取一个数作为划分值
            swap(nums, left+(int) (Math.random() * (right-left+1)), right);
            int[] res = partition(nums, left, right);
            quickSort(nums, left, res[0]-1);
            quickSort(nums, res[1] + 1, right);
        }
    }

    public static int[] partition(int[] arr, int left, int right) {
        //low为小于区右边界，p2为大于区左边界，index指针
        int low = left - 1, high = right;
        int index = left;
        while (index < high) {
            if (arr[index] < arr[right]) {
                swap(arr, index++, ++low);
            } else if (arr[index] > arr[right]) {
                swap(arr, index, --high);
            } else {
                index++;
            }
        }
        swap(arr, right, high);
        return new int[]{low + 1, high};
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
