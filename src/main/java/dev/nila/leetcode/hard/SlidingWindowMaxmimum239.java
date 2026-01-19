package dev.nila.leetcode.hard;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

public class SlidingWindowMaxmimum239 {

    /**
     * https://leetcode.com/problems/sliding-window-maximum/description/
     * You are given an array of integers nums, there is a sliding window of size k
     * which is moving from the very left of the array to the very right.
     * You can only see the k numbers in the window.
     * Each time the sliding window moves right by one position.
     *
     * Return the max sliding window.
     *
     *
     * Example 1:
     * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
     * Output: [3,3,5,5,6,7]
     * Explanation:
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *
     * Example 2:
     * Input: nums = [1], k = 1
     * Output: [1]
     *
     */

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,-1,-3,5,3,6,7};
        int k1 = 3;
        int[] nums2 = new int[]{1};
        int k2 = 1;
        int[] result = maxSlidingWindow(nums2, k2);
        System.out.println(Arrays.toString(result));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove indices outside the window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller values from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Record max when window is ready
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }


}
