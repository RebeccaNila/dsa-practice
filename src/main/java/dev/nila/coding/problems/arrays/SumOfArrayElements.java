package dev.nila.coding.problems.arrays;

public class SumOfArrayElements {

    //Q. Write a function to calculate the sum of all elements in an array
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};//input
        int result = calculateSum(nums);
        System.out.println(result);
    }

    public static int calculateSum(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum = sum + arr[i];
        }
        return sum;
    }
}
