package dev.nila.leetcode.medium;

public class MinSizeSubarraySum209 {

    /**
     * https://leetcode.com/problems/minimum-size-subarray-sum/description/
     * Given an array of positive integers nums and a positive integer target,
     * return the minimal length of a subarray whose sum is greater than or equal to target.
     * If there is no such subarray, return 0 instead.
     */

    public static void main(String[] args) {
        /**
         * 🐛 The Caterpillar Story (Concept)
         * 1. The Goal: The caterpillar wants to eat numbers until its tummy is full (sum >= target).
         * 2. The Rule: The caterpillar wants to be as short (small) as possible while still being full.
         * 3. How it moves:
         * Eat (Expand): It stretches its head to the right to eat more numbers.
         * Poop/Shrink (Contract): Once it is full, it pulls its tail in from the left to see if it can get shorter and still stay full.
         */

        /**
         * Example 1:
         *
         * Input: target = 7, nums = [2,3,1,2,4,3]
         * Output: 2
         * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
         *
         * Example 2:
         *
         * Input: target = 4, nums = [1,4,4]
         * Output: 1
         *
         * Example 3:
         *
         * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
         * Output: 0
         */
        int[] nums1 = new int[] {2,3,1,2,4,3};
        int target1 = 7;
        int[] nums2 = new int[] {1,4,4};
        int target2 = 4;
        int[] nums3 = new int[] {1,1,1,1,1,1,1,1};
        int target3 = 11;
        int result = minSubArrayLen(target1, nums1);
        System.out.println(result);

    }

//    private static int minSubArrayLenOptimized(int target, int[] nums) {
//        /**
//         * positive integer and target value
//         * min Sum >= target
//         * no value return 0
//         * variable type sliding window
//         */
//    }

    /**
     * 🧠 Logic Breakdown for Interviews
     * 1. Two Pointers: We use left (tail) and right (head).
     * 2. Expand right: We always add numbers to currentSum to try and reach the target.
     * 3. Shrink left (The while loop): This is the magic part. As soon as the sum is valid (>= target), we try to shrink the window from the left to make it as small as possible while keeping the sum valid.
     * 4. Time Complexity: O(N). Even though there is a loop inside a loop, the left pointer and right pointer each travel across the array at most one time.
     * 5. Space Complexity: O(1). We only use variables, no extra lists.
     * Sliding Window approach
     * When finding a Maximum, start with the Lowest possible number (e.g., 0 or Integer.MIN_VALUE).
     *
     * When finding a Minimum, start with the Highest possible number (e.g., Integer.MAX_VALUE).
     * WHEN must you use this logic? (The Checklist)
     * You should immediately think of this Sliding Window pattern when you see a problem with these 3 keywords:
     *
     * 1. "Subarray" (or Substring): The problem asks for a contiguous part of the array (elements next to each other). If the problem asked for a "Subsequence" (elements can be skipped), you cannot use this.
     *
     * 2. "Positive Numbers Only": This is the most critical rule. This logic only works because adding numbers (right++) always increases the sum, and removing numbers (left++) always decreases the sum.
     *
     *      Note: If the array had negative numbers (e.g., [3, -5, 10]), expanding the window might actually decrease the sum. In that case, this logic breaks, and you would need a different technique (Prefix Sum + HashMap).
     *
     * 3. "Minimal" or "Maximal" length: The problem asks for the smallest or largest window that satisfies a condition (like sum >= target).
     *
     * Feature	        Use Sliding Window?
     * Data Structure	Array or String
     * Elements	        Must be Contiguous (no skipping)
     * Values	        Positive (for sum problems)
     * Goal	            Find Max/Min length or Count subarrays
     */

    private static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE; // Start with a huge number
        int currentSum = 0; // Caterpillar's tummy level
        int left = 0;       // The Caterpillar's tail

        // 'right' is the Caterpillar's head moving forward
        for (int right = 0; right < nums.length; right++) {

            // 1. EAT (Add number to sum)
            currentSum += nums[right];

            // 2. CHECK: Is the tummy full? (Sum >= target)
            while (currentSum >= target) {
                // We found a valid window! Let's measure it.
                // Length = (Head - Tail) + 1
                int currentLength = right - left + 1;

                // Remember the smallest length we have seen so far
                minLength = Math.min(minLength, currentLength);

                // 3. SHRINK (Remove number from the tail to try and get smaller)
                currentSum -= nums[left];
                left++; // Move the tail forward
            }
        }

        // If minLength never changed, it means we never found a sum >= target
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    /**
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     *
     */
    private static int bruteForceApproach(int target, int[] nums){
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        // Outer Loop: Pick the starting point (i)
        for (int i = 0; i < n; i++) {
            int currentSum = 0;

            // Inner Loop: Pick the ending point (j)
            // We start j at i because a subarray can be just 1 number
            for (int j = i; j < n; j++) {
                currentSum += nums[j]; // Add the new number to the sum

                // Check if we hit the target
                if (currentSum >= target) {
                    int currentLength = j - i + 1;
                    minLength = Math.min(minLength, currentLength);

                    // Optimization: Break here!
                    // Since we want the *smallest* length, adding more numbers
                    // to this specific start point 'i' makes it longer, which is useless.
                    break;
                }
            }
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }


}
