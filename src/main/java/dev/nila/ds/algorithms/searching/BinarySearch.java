package dev.nila.ds.algorithms.searching;

public class BinarySearch {

    static void main(String[] args) {
        int[] arr = { 2, 4, 5, 6, 7, 9, 12};
        //int[] arr = { 12, 9, 7, 6, 5, 3, 1};
        int target = 7;
        System.out.println("Binary Search "+binarySearch(arr, target));
        System.out.println("Binary Search using recursive "+binarySearchRecursive(arr, target, 0, arr.length - 1));
    }

    private static int binarySearchRecursive(int[] arr, int target, int left, int right){

        //int left = 0, right = arr.length - 1;
        int mid = (left+right)/2;
        if(left > right) return -1;
        if(arr[mid] == target)
            return mid;
        if(arr[mid] < target)
            return binarySearchRecursive(arr, target, mid + 1, right);
        else
            return binarySearchRecursive(arr, target, left, mid - 1);

    }

    private static int binarySearch(int[] arr, int target){

        int left = 0, right = arr.length - 1;
        boolean isAsc = arr[left] < arr[right];
        while(left <= right){
            int mid = (left+right)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                if(isAsc){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }

            }else{
                if(isAsc){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

}
