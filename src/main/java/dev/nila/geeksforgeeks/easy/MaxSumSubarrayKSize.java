package dev.nila.geeksforgeeks.easy;

public class MaxSumSubarrayKSize {

    /**
     * Link : https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
     * Given an array of integers arr[]  and a number k.
     * Return the maximum sum of a subarray of size k.
     *
     * Note: A subarray is a contiguous part of any given array.
     */

    public static void main(String[] args) {

        /**
         * Eg.1
         * Input: arr[] = [100, 200, 300, 400], k = 2
         * Output: 700
         * Explanation: arr2 + arr3 = 700, which is maximum.
         * Eg.2
         * Input: arr[] = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
         * Output: 39
         * Explanation: arr1 + arr2 + arr3 + arr4 = 39, which is maximum.
         * Eg.3
         * Input: arr[] = [100, 200, 300, 400], k = 1
         * Output: 400
         * Explanation: arr3 = 400, which is maximum.
         */

        int res = 0;
        int num1[] = new int[]{100, 200, 300, 400};
        int num2[] = new int[]{1, 4, 2, 10, 23, 3, 1, 0, 20};
        int num3[] = new int[]{100, 200, 300, 400};
        int arr[] = num3;
        int k = 1;

        int low = 0, high = k - 1, sum = 0, n = arr.length;
        for(int i=0; i<=high; i++){
            sum += arr[i];
        }
        res = sum;
        while(high < n){
            low++;
            high++;
            if(high == n) break;
            sum = sum - arr[low-1] + arr[high];
            if(res < sum) res = sum;
        }
        System.out.println("Max Sum "+res);

    }
}
