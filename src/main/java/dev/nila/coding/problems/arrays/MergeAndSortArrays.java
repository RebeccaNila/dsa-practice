package dev.nila.coding.problems.arrays;

import java.util.Arrays;
public class MergeAndSortArrays {
    //Q.Write a function to merge two arrays into a single sorted array.

    /**
     * Create empty new array
     * Merged array
     * Merged & sorted array
     *
     */
    public static void main(String[] args) {
        int[] nums1 = { 3, 5, 1, 4 };
        int[] nums2 = { 8, 2, 7, 6 };
        int[] result = mergeAndSortArrays(nums1, nums2);
        System.out.println("MergeAndSortedArrays: "+Arrays.toString(result));
    }

    private static int[] mergeAndSortArrays(int[] arr1, int[] arr2){
        int n = arr1.length, m = arr2.length;
        //Create a new array to hold elements to both arrays
        int[] mergeArray = new int[n+m];
        //Copy element from the first array using for loop
        for(int i=0; i<n; i++){
            mergeArray[i] = arr1[i];
        }
        //Copy element from the second array using for loop
        for(int i=0; i<m; i++){
            mergeArray[n+i] = arr2[i];
        }
        //Sort the merge array
        Arrays.sort(mergeArray);
        return mergeArray;
    }
}
