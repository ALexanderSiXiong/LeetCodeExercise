package leetCode.Sort;

import java.util.Arrays;

public class MergeSortedArray88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 2019.03.20 - 20 min
        // wasted some time in using nested for loops
        // step 1. put all the digits in nums2 into num1 after the index of the last digit in num1
        // step 2. library's sort func - Arrays.sort(int[])
        int i = m;
        for(int j = 0; j <= n - 1; j++) {
            nums1[i] = nums2[j];
            i++;
        }

        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        merge(nums1, 3, nums2, 3);
    }
}
