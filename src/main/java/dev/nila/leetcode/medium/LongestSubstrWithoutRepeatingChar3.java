package dev.nila.leetcode.medium;

import java.util.Set;
import java.util.HashSet;

public class LongestSubstrWithoutRepeatingChar3 {
    /**
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
     * Given a string s, find the length of the longest substring without duplicate characters.
     *
     * Example 1:
     *
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
     * Example 2:
     *
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        int result = lengthOfLongestSubstring(s3);
        System.out.println("Longest Substring Without Repeating Characters "+result);
    }

    private static int lengthOfLongestSubstring(String s) {
        /**
         * given string
         * without duplicate
         * variable type
         * return longestLen
         *
         * 1. What makes the window invalid? -> char already exits in window
         * 2. What data structure tracks validity? -> Set
         * 3. When do I update the answer? -> is valid
         *
         */
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0, n = s.length();
        for(int right =0; right<n; right++){
            //shrink char already exists in window/set
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            //expand
            set.add(s.charAt(right));
            //update when is valid
            maxLen = Math.max(maxLen, right - left +1);
//            System.out.println(set);
        }
        return maxLen;
    }

}
