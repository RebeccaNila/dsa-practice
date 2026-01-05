package dev.nila.leetcode.hard;

import java.util.Map;
import java.util.HashMap;

public class LongestSubstrWithoutRepeatingChar3 {

    /**
     * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
     *
     * Given a string s, find the length of the longest substring without duplicate characters.
     * "A substring is a contiguous non-empty sequence of characters within a string."
     *
     * Example 1:
     *
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
     *
     * Example 2:
     *
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     *
     * Example 3:
     *
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    public static void main(String[] args) {
        String str1 = "abcabcbb";
        String str2 = "bbbbb";
        String str3 = "pwwkew";
        int result = LongestSubstrWithoutRepeatingChar(str3);
        System.out.println("3. Longest Substring Without Repeating Characters "+result);

    }

    private static int LongestSubstrWithoutRepeatingChar(String s){
        //Substring, unique,
        //variable
        int maxLength = 0, left = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < n; right++){
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0)+1);
            int k = right - left + 1;
            while(map.size() < k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar)-1);
                if(map.get(leftChar) == 0)
                    map.remove(leftChar);
                left++;
                k = right - left + 1;
            }

            maxLength = Math.max(maxLength, right - left +1);

        }
        return maxLength;
    }
}
