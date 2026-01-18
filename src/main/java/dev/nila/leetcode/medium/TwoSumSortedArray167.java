package dev.nila.leetcode.medium;
import java.util.Arrays;
public class TwoSumSortedArray167 {

    /**
     * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
     *
     * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
     * find two numbers such that they add up to a specific target number.
     * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
     *
     * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
     *
     * The tests are generated such that there is exactly one solution. You may not use the same element twice.
     *
     * Your solution must use only constant extra space.
     */

    public static void main(String[] args) {
        /**
         * Example 1:
         *
         * Input: numbers = [2,7,11,15], target = 9
         * Output: [1,2]
         * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
         * Example 2:
         *
         * Input: numbers = [2,3,4], target = 6
         * Output: [1,3]
         * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
         * Example 3:
         *
         * Input: numbers = [-1,0], target = -1
         * Output: [1,2]
         * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
         */

        int[] numbers1 = new int[] {2,7,11,15};
        int target1 = 9;
        int[] numbers2 = new int[] {2,3,4};
        int target2 = 6;
        int[] numbers3 = new int[] {-1,0};
        int target3 = -1;
        int[] result = twoSumSortedArray(numbers3, target3);
        System.out.println(Arrays.toString(result));

    }

    private static int[] twoSumSortedArray(int[] numbers, int target){
        /**
         * sorted,
         * non-decreasing order (ASC)
         *  if sum > target then reduce right
         *  if sum < target then increase left
         * return index
         * can't use same element twice
         * space O(1)
         */
        int left = 0;
        int n = numbers.length, right = n-1;
        if(numbers.length == 0 || numbers.length == 1) return new int[] {0, 0};
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target) return new int[] {++left, ++right};
            if(sum < target) left++;
            if(sum > target) right--;
        }

        return new int[] {0, 0};
    }

}
