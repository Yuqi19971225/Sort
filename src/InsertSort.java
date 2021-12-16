import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int maxSize = 10;
        int maxNum = 100;
        int[] arr1 = generator(maxSize, maxNum);
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        insertSort(arr1);
        Arrays.sort(arr2);
        comparetor(arr1, arr2);
    }

    public static void insertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j + 1] < nums[j]) swap(nums, j + 1, j);
                else break;
            }
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
