package leetCode;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int times = 0;
        int maxIndex = nums.length - 1;
        int maxJump = nums[0];

        for(int i = 0; i < nums.length; i++){
            if(maxJump >= i){
                maxJump = Math.max(i+nums[i], maxJump);
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean canJump2(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }

        int range = nums[0];

        for(int i = 0; i < nums.length - 1; i++){
            if(range >= i){
                range = Math.max(range, i + nums[i]);
            } else {
                return false;
            }
        }

        if(range >= nums.length - 1){
            return true;
        }

        return false;
    }



    public static void main(String[] args) {
        int[] test = {1,0,1,0};
        System.out.println(canJump2(test));
    }
}