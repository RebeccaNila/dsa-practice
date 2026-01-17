package dev.nila;

import java.util.Set;
import java.util.HashSet;

public class SlidingWindow {

    /**
     *
     * Time Limit: 30 MinutesThis is a "Medium" difficulty problem, very common for Senior roles.
     * Problem: "Longest Substring Without Repeating Characters"Given a string s,
     * find the length of the longest substring without repeating characters.
     * Examples: Input: s = "abcabcbb" -> Output: 3 (The substring is "abc")
     * Input: s = "bbbbb" -> Output: 1 (The substring is "b")
     * Input: s = "pwwkew" -> Output: 3 (The substring is "wke")
     * Constraints:0 <= s.length <= 5. 10^4
     * s consists of English letters, digits, symbols and spaces.
     */

    public static void main(String[] args) {
        String str1 = "abcabcbb";
        int result = lengthOfLongestSubstring(str1);
        System.out.println(result);
    }

    private static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for(int right=0; right < s.length(); right++){

            //// While the current char is already in the set, shrink the window from the left
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;

    }
}
