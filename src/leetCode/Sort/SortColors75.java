package leetCode.Sort;

public class SortColors75 {
    // 2019.03.20 - 40 min
    public static void sortColors(int[] nums) {
        int length = nums.length;

        // calculate the total number of each color
        int zero = 0;
        int one = 0;
        int two = 0;

        // reviewed switch
        for(int i = 0; i < length; i++) {
            int digit = nums[i];
            switch (digit) {
                case 0:
                    zero++;
                    break;
                case 1:
                    one++;
                    break;
                case 2:
                    two++;
                    break;
                default:
                    break;
            }
        }

        for(int i = 0; i < length; i++){
            // to avoid being confused by the index
            int pointer = i + 1;
            if(pointer <= zero){
                nums[i] = 0;
            } else if( pointer > zero && pointer <= zero + one){
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] num = {2,0,2,1,1,0};
        sortColors(num);
    }
}
