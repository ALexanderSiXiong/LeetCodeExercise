package leetCode;

public class RemoveDuplicatesfromSortedArrayII {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int times = 1;
        int cur = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[cur]){
                cur++;
                nums[cur] = nums[i];
                times= 1;
            } else if (nums[i] == nums[cur]){
                times++;
                if(times == 2){
                    cur++;
                    nums[cur] = nums[cur - 1];

                }
            }
        }
        return cur + 1;
    }

    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int number : nums)
            if (i < 2 || number > nums[i-2]) {
                nums[i] = number;
                i++;
            }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 3};

        System.out.println(removeDuplicates2(arr));

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
