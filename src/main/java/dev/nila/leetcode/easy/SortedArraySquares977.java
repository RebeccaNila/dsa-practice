package dev.nila.leetcode.easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class SortedArraySquares977 {

    /**
     * https://leetcode.com/problems/squares-of-a-sorted-array/description/
     * Solution: https://www.youtube.com/watch?v=DJqYOsrqyy0
     * Given an integer array nums sorted in non-decreasing order,
     * return an array of the squares of each number sorted in non-decreasing order.
     *
     * Follow up: Squaring each element and sorting the new array is very trivial,
     * could you find an O(n) solution using a different approach?
     * Example 1:
     *
     * Input: nums = [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     * Explanation: After squaring, the array becomes [16,1,0,9,100].
     * After sorting, it becomes [0,1,9,16,100].
     * Example 2:
     *
     * Input: nums = [-7,-3,2,3,11]
     * Output: [4,9,9,49,121]
     */

    public static void main(String[] args) {
        int[] nums1 = new int[] {-4,-1,0,3,10};
        int[] nums2 = new int[] {-7,-3,2,3,11};
        sortedSquares(nums2);
        System.out.println(Arrays.toString(nums2));


    }

    /**
     * The Optimized Solution (Two Pointers)
     * The "Valley" Concept
     * Imagine your numbers on a graph. Because the array is sorted, the squared values form a "valley" shape:
     * Left End: Large squares (from negative numbers like -4² = 16).
     * Middle: Small squares (near 0).
     * Right End: Large squares (from positive numbers like 10² = 100).
     * We know the biggest squares are always on the outside edges.
     * Step-by-Step Visualization
     * Let's trace the array: [-4, -1, 0, 3, 10] We need to fill the result array [_, _, _, _, _] starting from the end (index 4).
     *
     * Step 1: Compare the Ends
     *      Left Pointer is at -4 (Square: 16)
     *      Right Pointer is at 10 (Square: 100)
     *      Compare: 100 > 16. The Right side wins.
     *      Action: Put 100 at the end. Move Right pointer in.
     *      Result: [_, _, _, _, 100]
     *
     * Step 2: Compare the New Ends
     *      Left Pointer is at -4 (Square: 16)
     *      Right Pointer is at 3 (Square: 9)
     *      Compare: 16 > 9. The Left side wins.
     *      Action: Put 16 in the next empty spot. Move Left pointer in.
     *      Result: [_, _, _, 16, 100]
     * Step 3: Compare the New Ends
     *      Left Pointer is at -1 (Square: 1)
     *      Right Pointer is at 3 (Square: 9)
     *      Compare: 9 > 1. The Right side wins.
     *      Action: Put 9 in the next spot. Move Right pointer in.
     *      Result: [_, _, 9, 16, 100]
     *
     * Step 4: Compare the New Ends
     *      Left Pointer is at -1 (Square: 1)
     *      Right Pointer is at 0 (Square: 0)
     *      Compare: 1 > 0. The Left side wins.
     *      Action: Put 1 in the next spot. Move Left pointer in.
     *      Result: [_, 1, 9, 16, 100]
     *
     * Step 5: Final Number
     *      Both pointers meet at 0.
     *      Action: Put 0 in the last spot.
     * Final Result: [0, 1, 9, 16, 100]
     * Why this is optimized
     * Your Code: Looked at the numbers, split them into lists, squared them, reversed one list, and then merged them.
     *
     * Optimized: Just looked at the edges and picked the winner. It touched each number exactly once.
     */

    public int[] sortedSquaresOptimize(int[] nums) {
        int n = nums.length;
        int[] result = new int[n]; // The only extra space used

        int left = 0;
        int right = n - 1;
        int index = n - 1; // Start filling from the end

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }
            index--;
        }

        return result;
    }

    private static int[] sortedSquares(int[] nums) {
        /**
         * Create two arrayList positive and negative List
         * if there is no negative array
         *  loop the positive array and square
         * if there is no positive array
         *  loop the negative array and square
         *  revere the negative array
         *
         */
        ArrayList<Integer> positiveList = new ArrayList<>();
        ArrayList<Integer> negativeList = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i < n; i++){
            if(nums[i] >= 0){
                positiveList.add(nums[i]);
            }else{
                negativeList.add(nums[i]);
            }
        }

        //if there is no negative array
        if(negativeList.isEmpty()){
            for(int i=0; i<positiveList.size(); i++){
                nums[i] = nums[i] * nums[i];
            }
        }


        //if there is no positive array
        //Arrays.reverse(negArr);
        if(positiveList.isEmpty()){
            for(int i=0; i<negativeList.size(); i++){
                nums[i] = nums[i] * nums[i];
            }
            reverseArray(nums);
        }
        //if there is value for both positive and negative
        //square the value of both positive and negative linked list
        // then reverseArray for negateive because that sorted array is in dec order
        int posListSize = positiveList.size(), negListSize = negativeList.size();

        //square the positive array value
        for(int i=0; i<posListSize; i++){
            int square = positiveList.get(i) * positiveList.get(i);
            positiveList.set(i, square);
        }
        System.out.println("Positive List "+positiveList.toString());
        //square the positive array value and resverse the array due to sorted in desc after square in negative array
        for(int i=0; i<negListSize; i++){
            int square = negativeList.get(i) * negativeList.get(i);
            negativeList.set(i,square);
        }
        //reverseArray(negativeList.toArray());
        Collections.reverse(negativeList);
        System.out.println("Negative List "+negativeList.toString());
        int posListIndex = 0, negListIndex = 0, numsIndex = 0;
        while(posListIndex < posListSize && negListIndex < negListSize){
            int posValue = positiveList.get(posListIndex), negValue = negativeList.get(negListIndex);
            if(posValue < negValue ){
                nums[numsIndex] = posValue;
                posListIndex++;
            }else{
                nums[numsIndex] = negValue;
                negListIndex++;
            }
            numsIndex++;
        }

        if(posListIndex < posListSize){
            nums[numsIndex] = positiveList.get(posListIndex);
            numsIndex++;
            posListIndex++;
        }
        if(negListIndex < negListSize){
            nums[numsIndex] = negativeList.get(negListIndex);
            numsIndex++;
            negListIndex++;
        }
        return nums;
    }

    private static void reverseArray(int[] nums){
        int left = 0, right = nums.length-1;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
