package dev.nila.coding.problems.basic;
import java.util.Map;
import java.util.HashMap;

public class TwoSums {

    public static void main(String[] args) {

    }

    private static int[] twoSums(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(i, nums[i]);
        }
        return new int[]{};
    }
}
