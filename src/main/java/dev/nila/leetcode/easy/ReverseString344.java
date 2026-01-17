package dev.nila.leetcode.easy;

import java.util.Arrays;

public class ReverseString344 {

    /**
     * https://leetcode.com/problems/reverse-string/description/
     *
     * Write a function that reverses a string. The input string is given as an array of characters s.
     *
     * You must do this by modifying the input array in-
     *
     * Example 1:
     *
     * Input: s = ["h","e","l","l","o"]
     * Output: ["o","l","l","e","h"]
     * Example 2:
     *
     * Input: s = ["H","a","n","n","a","h"]
     * Output: ["h","a","n","n","a","H"]
     */

    public static void main(String[] args) {
        char[] chars1 = new char[] {'h','e','l','l','o'};
        char[] chars2 = new char[] {'H','a','n','n','a','h'};
        reverseString(chars2);
        System.out.println(Arrays.toString(chars2));
    }

    private static void reverseString(char[] s) {
        /**
         * left start with zero and right start with length -1;
         * while loop till left < right
         * each loop swap left and right value
         * then increase left decrease right
         *
         */
        int left = 0, right = s.length - 1;
        while(left < right){
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }

    }
}
