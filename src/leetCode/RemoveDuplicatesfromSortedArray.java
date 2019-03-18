package leetCode;

public class RemoveDuplicatesfromSortedArray {
    // leetcode 26

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int temp = nums[0];
        int index = 0;

        int count = 1; // 因为这个数组长度不是0，至少有一个数，所以 count 直接从1开始计数
        for(int i = 1; i < nums.length; i++){
            if(temp != nums[i]){
                temp = nums[i];
                index++;
                nums[index] = temp;
                count++;
            }
        }
        return count;
    }

    // 这个办法的双指针有点像快排
    public static int removeDuplicates2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int res = 1;

        for(int i = 1; i < nums.length; i++){
            System.out.print("[");
            for(int k = 0; k < nums.length; k++){
                System.out.print(nums[k]);
                if( k < nums.length - 1){
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            System.out.println();
            if(nums[i] > nums[i - 1]){
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,2,2,2,3,4,4,5};

        System.out.println(removeDuplicates2(arr));

        System.out.print("[");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if( i < arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
