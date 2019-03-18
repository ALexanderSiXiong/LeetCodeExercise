package leetCode;

public class FirstMissingPositive {
    // 有点像桶排
    public static int firstMissingPositive(int[] nums) {
        // 情况1
        if(nums == null || nums.length == 0){
            return 1;
        }

        for(int i = 0; i < nums.length; i++){
            while(  nums[i] <= nums.length &&
                    nums[i] > 0 &&
                    // 这个地方不能写成 nums[i] != i + 1 不然在处理[1,1] 会无限循环
                    // 严谨逻辑 --- 从数组里面去判断，这两个数是否相等
                    // 而不是从i+1去判断
                    nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }

        }


        int i = 0;

        while(i < nums.length && nums[i] == i + 1){
            i++;
        }

        return i + 1;


//        // 情况2
//        for(int i = 0; i < nums.length; i++){
//            if(i != nums[i] - 1){
//                return i + 1;
//            }
//        }
//        // 情况3 如果分3种情况，第三种情况容易漏掉
//        // 把这个边界考虑进去？[1,2,3,4] -> return 5
//        return nums.length + 1;


    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] test = {1,1};
        System.out.println(firstMissingPositive(test));
    }
}
