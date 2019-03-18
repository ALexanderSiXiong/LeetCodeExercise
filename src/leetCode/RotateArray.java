package leetCode;

public class RotateArray {

    public static void rotate(int[] arr, int times){
        rotate(arr, arr.length - 1, times);
    }

    private static void rotate(int[] nums, int numsSize, int k) {
        if(k == 0) return;
        do {
            int temp = nums[numsSize];
            for (int i = numsSize; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            k--;
        } while(k != 0); // 达到这个条件就停下来
    }

    public static void main(String[] args) {
        int[] arr = {1};
        int times = 0;

        rotate(arr, times);

        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");

    }
}
