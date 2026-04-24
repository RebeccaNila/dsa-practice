package dev.nila.leetcode.easy;

import java.util.Map;
import java.util.HashMap;

public class SingleNumber136 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1};
        int result1 = findUniqueUsingNestedLoop(arr);
        int result2 = findUniqueUsingMap(arr);
        int result3 = findUniqueUsingBitwiseXor(arr);
        System.out.println("Loop Result: "+result1);
        System.out.println("Hash Map Result: "+result2);
        System.out.println("Bitwise Xor Result: "+result3);
    }

    private static int findUniqueUsingBitwiseXor(int[] arr){
        //TC: O(N)
        //SC: O(1)
        if(arr.length == 1) return arr[0];
        int unique = 0;
        // Loop through the array and XOR every element
        for(int num : arr){
            unique ^= num;
        }
        return unique;
    }

    private static int findUniqueUsingMap(int[] arr){
        //TC: O(N)
        //SC: O(n)
        if(arr.length == 1) return arr[0];
        Map<Integer, Integer> map = new HashMap<>();
        // Count occurrences
        for(int num: arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        // Find the one with count 1
        for(int key : map.keySet()){
            if(map.get(key) == 1) return key;
        }
        return -1;
    }

    private static int findUniqueUsingNestedLoop(int[] arr){
        //TC: O(N^2)
        //SC: O(1)
        if(arr.length == 1) return arr[0];
        // Outer loop: pick one number at a time
        for(int i = 0; i < arr.length; i++){
            int count = 0;
            // Inner loop: check this number against every other number
            for(int j = 0; j < arr.length; j++){
                if(arr[i] == arr[j]) count++;
//                System.out.println("i "+i+" value: "+arr[i]+" j "+j+" value: "+arr[j]);
            }
            // If the count is exactly 1, we found the unique element
            if(count == 1){
                //System.out.println("value "+arr[i]);
                return arr[i];
            }
        }
        return -1;
    }
}
