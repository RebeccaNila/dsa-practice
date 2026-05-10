package dev.nila.ds.algorithms.searching;

import java.util.Arrays;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 5;
        System.out.println(findIndex(arr, target));
        System.out.println(contains(arr, target));
        String str = "hi there!";
        char ch = 'j';
        System.out.println(findIndexString(str, ch));
        System.out.println(containsString(str, ch));
        int[][] arr2 = {{1, 2}, {3, 4, 5}, {6}};
        int target2 = 5;
        System.out.println("2 dimensional array " + Arrays.toString(findIndex2DimensionalArray(arr2, target2)));
        System.out.println("2 dimensional array " + contains2DimensionalArray(arr2, target2));

    }


    private static int findIndex(int[] arr, int target){
        if(arr == null || arr.length == 0) return -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target) return i;
        }
        return -1;
    }

    private static boolean contains(int[] arr, int target){
        if(arr == null || arr.length == 0) return false;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target) return true;
        }
        return false;
    }
    private static int findIndexString(String str, char target){
        if(str == null || str.length() == 0) return -1;
        int n = str.length();
        for(int i = 0; i < n; i++){
            if (str.charAt(i) == target) return i;
        }
        return -1;
    }

    private static boolean containsString(String str, char target){
        if(str == null || str.length() == 0) return false;
        int n = str.length();
        for(int i = 0; i < n; i++){
            if (str.charAt(i) == target) return true;
        }
        return false;
    }

    private static int[] findIndex2DimensionalArray(int[][] arr, int target){
        if(arr == null || arr.length == 0) return new int[] {-1, -1};
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++ )
            if(arr[i][j] == target) return new int[] {i, j};;
        }
        return new int[] {-1, -1};
    }

    private static boolean contains2DimensionalArray(int[][] arr, int target){
        if(arr == null || arr.length == 0) return false;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++ )
                if(arr[i][j] == target) return true;
        }
        return false;
    }


}
