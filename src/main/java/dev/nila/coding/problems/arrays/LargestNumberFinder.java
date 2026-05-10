package dev.nila.coding.problems.arrays;

public class LargestNumberFinder {
    //Q.Write a function to find the largest number in an array.
    public static void main(String[] args) {
        int[] nums = { 10, 7, 23, 45, 8}; //input
        int result = findLargestNumber(nums);
        System.out.println(result);
    }
    private static int findLargestNumber(int[] arr){
        //Assume the first element as the largest number
        int largest = arr[0];
        //Iterate through the array to find the largest number
        for(int i=1; i<arr.length; i++){
            //Update the largest if a larger number is found
           if(arr[i] > largest)  largest = arr[i];
        }
        return largest;
    }
}
