package dev.nila.leetcode.medium;

import java.util.Map;
import java.util.HashMap;

public class FruitIntoBaskets904 {

    /**
     * Link: https://leetcode.com/problems/fruit-into-baskets/
     *
     * You are visiting a farm that has a single row of fruit trees arranged from left to right.
     * The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
     *
     * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
     *
     * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
     * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right.
     * The picked fruits must fit in one of your baskets.
     * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
     * Given the integer array fruits, return the maximum number of fruits you can pick.
     *
     * Example 1:
     *
     * Input: fruits = [1,2,1]
     * Output: 3
     * Explanation: We can pick from all 3 trees.
     *
     * Example 2:
     *
     * Input: fruits = [0,1,2,2]
     * Output: 3
     * Explanation: We can pick from trees [1,2,2].
     * If we had started at the first tree, we would only pick from trees [0,1].
     *
     * Example 3:
     *
     * Input: fruits = [1,2,3,2,2]
     * Output: 4
     * Explanation: We can pick from trees [2,3,2,2].
     * If we had started at the first tree, we would only pick from trees [1,2].
     */

    public static void main(String[] args) {
        int[] fruits1 = new int[] {1,2,1};
        int[] fruits2 = new int[] {0,1,2,2};
        int[] fruits3 = new int[] {1,2,3,2,2};
        int result = maxNumberOfFruits(fruits3);
        System.out.println(result);
        //array, maxNumber


    }

    private static int maxNumberOfFruits(int[] fruits){
        //1,2,1
        int maxLength = 0, left = 0, n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int right = 0; right < n; right++){
            int rightFruit = fruits[right];
            map.put(rightFruit, map.getOrDefault(rightFruit, 0)+1);

            // shrink window if more than 2 fruit types
            while(map.size() > 2){
                int leftFruit = fruits[left];
                map.put(leftFruit, map.get(leftFruit)-1);
                if(map.get(leftFruit) == 0)
                    map.remove(leftFruit);
                left++;
            }
            maxLength = Math.max(maxLength, right - left +1);
        }
        return maxLength;
    }


}
