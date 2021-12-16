import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int maxSize = 10;
        int maxNum = 100;
        int[] arr1 = generator(maxSize, maxNum);
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        mergeSort(arr1, 0, arr1.length - 1);
        Arrays.sort(arr2);
        comparetor(arr1, arr2);
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left == right) return;
        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        nums = merge(nums, left, mid, right);
    }

    public static int[] merge(int[] nums, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p1 = left, p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            help[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid) {
            help[i++] = nums[p1++];
        }
        while (p2 <= right) {
            help[i++] = nums[p2++];
        }
        for(i=0;i<help.length;++i){
            nums[left+i]=help[i];
        }
        return nums;
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
