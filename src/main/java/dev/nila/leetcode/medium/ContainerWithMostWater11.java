package dev.nila.leetcode.medium;

public class ContainerWithMostWater11 {

    /**
     * https://leetcode.com/problems/container-with-most-water/description/
     *
     * You are given an integer array height of length n.
     * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     *
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     *
     * Return the maximum amount of water a container can store.
     *
     * Notice that you may not slant the container.
     *
     *
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
     * In this case, the max area of water (blue section) the container can contain is 49.
     * Example 2:
     *
     * Input: height = [1,1]
     * Output: 1
     */

    public static void main(String[] args) {
        int[] numbers1 = new int[] {1,8,6,2,5,4,8,3,7};
        int[] numbers2 = new int[] {1,1};
        int result = largestArea(numbers1);
        System.out.println("Largest Area container with most water "+result);

    }

    private static int largestArea(int[] height){
        /**
         * 1. Calculating Area
         * 2. Moving pointer to less side to get next area
         * 3. Comparing area and store largest area
         * 4. reutrn largest area
         */
        int left = 0, n = height.length - 1, right = n, maxArea = 0;
        while(left < right){
            int currentArea = Math.min(height[right], height[left]) * (right-left);
            if(height[left] < height[right] || height[left] == height[right] ){
                left++;
            }else{
                right--;
            }
            maxArea = Math.max(currentArea, maxArea);
        }
        return maxArea;

    }
}
