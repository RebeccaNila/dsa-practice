package dev.nila.leetcode.easy;

public class MaxAverageSubarrI643 {

    /**
     * https://leetcode.com/problems/maximum-average-subarray-i/description/
     * Solution:
     * You are given an integer array nums consisting of n elements, and an integer k.
     *
     * Find a contiguous subarray whose length is equal to k that has the
     * maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,12,-5,-6,50,3], k = 4
     * Output: 12.75000
     * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
     * Example 2:
     *
     * Input: nums = [5], k = 1
     * Output: 5.00000
     */

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,12,-5,-6,50,3};
        int k1 = 4;
        int[] nums2 = new int[] {5};
        int k2 = 1;
        double result = findMaxAverage(nums1, k1);
        System.out.println("Find Maximum Average Subarray  "+result);
    }

    private static double findMaxAverage(int[] nums, int k) {
        //contiguous subarray
        // Fixed size
        // return max average value
        /**
         *
         */
        int windowSum = 0, n = nums.length;
        double windowAvg = 0.00, maxAvg = 0;
        for(int i=0; i<k; i++){
            windowSum += nums[i];
        }
        windowAvg = (double) windowSum/k;
        maxAvg = windowAvg;
        for(int right = k; right < n; right++){
            //expand window
            windowSum += nums[right];
            //shrink window
            windowSum -= nums[right-k];
            windowAvg = (double) windowSum/k;
            maxAvg = Math.max(maxAvg, windowAvg);
        }
        return maxAvg;
    }
}

