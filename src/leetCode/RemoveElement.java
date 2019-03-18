package leetCode;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            System.out.println();
            System.out.println("Start");
            System.out.println("l = " + l);
            System.out.println("r = " + r);
            System.out.println("First");
            System.out.print("[");
            for(int i = 0; i < nums.length; i++){
                System.out.print(nums[i]);
                if( i < nums.length - 1){
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            System.out.println();



            if(nums[l] == val){
                nums[l] = nums[r];
                r--;

                // nums[l] = nums[r--]; 和上面是等价的



                System.out.println();
                System.out.println("Second");
                System.out.print("[");
                for(int i = 0; i < nums.length; i++){
                    System.out.print(nums[i]);
                    if( i < nums.length - 1){
                        System.out.print(", ");
                    }
                }
                System.out.print("]");
                System.out.println();
                System.out.println();



            } else {
                l ++;

            }
        }
        return l;
    }


    public static void main(String[] args) {
        int[] arr1 = {0,1,2,2,3,0,4,2};

        System.out.println("-------------");
        System.out.println(removeElement(arr1, 2));

        System.out.print("[");
        for(int i = 0; i < arr1.length; i++){
            System.out.print(arr1[i]);
            if( i < arr1.length - 1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
