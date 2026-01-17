package dev.nila.leetcode.easy;

import java.util.Arrays;

public class MoveZeros283 {
    /**
     * https://leetcode.com/problems/move-zeroes/description/
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *
     * Note that you must do this in-place without making a copy of the array.
     *
     * Example 1:
     *
     * Input: nums = [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Example 2:
     *
     * Input: nums = [0]
     * Output: [0]
     */

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,3,12,0,0};
        int[] nums2 = new int[] {0};
        moveZeros(nums2);
        System.out.println("Move Zeros "+Arrays.toString(nums2));
    }

    private static void moveZeros(int[] nums){
        /**
         * left index start with 0
         * i = 0 loop through < n
         * if nums[i] != zero then swap nums
         */
        int left = 0, n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}
