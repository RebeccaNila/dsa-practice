package dev.nila.coding.problems.arrays;

public class SecondLargestElement {
    //Q.Write a function to find the second largest number in an array
    public static void main(String[] args) {
        int[] nums = {10, 7, 23, 45, 30}; //input
        int result = findSecondLargest(nums);
        System.out.println("SecondLargestElement "+result);
    }

    /**
     * Solve the simple case first;
     * Solve the edge case or complex cases later.
     *
     */

    private static int findSecondLargest(int[] arr){
        //set initial 0 or first array
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            int num = arr[i];
            if(num > largest){
                //first assign second largest not to lose
                secondLargest = largest;
                largest = arr[i];
            }//{10, 7, 23, 45, 30}
            else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }
}
