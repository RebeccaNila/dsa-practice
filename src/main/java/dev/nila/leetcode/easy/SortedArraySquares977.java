package dev.nila.leetcode.easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class SortedArraySquares977 {

    /**
     * https://leetcode.com/problems/squares-of-a-sorted-array/description/
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
