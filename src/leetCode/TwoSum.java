package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 5, 11};
        int target = 10;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }

//    第一个，一般方法
//    public static int[] twoSum(int[] nums, int target){
//        int[] result = new int[]{0,1};
//        if (nums.length == 2){
//            return result;
//        }
//
//        for(int i = 0; i < nums.length - 1; i++){ // 外循环不会到最后一个数
//                for(int j = i+1; j < nums.length; j++){ // 内层循环不会访问第一个数
//                    // 内层循环初始化从i+1开始，如果从1开始的话，可能会出现[2,2]的结果
//                    // 例如
//                    int[] nums = new int[]{2, 5, 5, 11};
//                    int target = 10;
//                    if (nums[i]+nums[j] == target){
//                        result[0] = i;
//                        result[1] = j;
//                    }
//                }
//        }
//        return result;
//    }

//      第二个方法，用Map，containsKey
//        public static int[] twoSum(int[] nums, int target){
//            int[] result = new int[]{0,1};
//
//            if (nums.length == 2){
//                return result;
//            }
//
//            Map<Integer, Integer> map = new HashMap<>();
//            for(int i = 0; i < nums.length; i++){
//                if(map.containsKey(target - nums[i])){
//                    result[1] = i+1;
//                    result[0] = map.get(target - nums[i]);
//                }
//            }
//
//            return result;
//        }
public static int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
        if (map.containsKey(target - numbers[i])) {
            result[1] = i + 1;
            result[0] = map.get(target - numbers[i]);
            return result;
        }
        map.put(numbers[i], i + 1);
    }
    return result;
}
}
