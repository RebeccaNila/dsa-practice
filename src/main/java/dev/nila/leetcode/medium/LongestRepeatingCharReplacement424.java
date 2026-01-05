package dev.nila.leetcode.medium;

public class LongestRepeatingCharReplacement424 {

    /**
     * Link: https://leetcode.com/problems/longest-repeating-character-replacement/description/
     * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
     *
     * Return the length of the longest substring containing the same letter you can get after performing the above operations.
     *
     * Example 1:
     *
     * Input: s = "ABAB", k = 2
     * Output: 4
     * Explanation: Replace the two 'A's with two 'B's or vice versa.
     *
     * Example 2:
     *
     * Input: s = "AABABBA", k = 1
     * Output: 4
     * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
     * The substring "BBBB" has the longest repeating letters, which is 4.
     * There may exists other ways to achieve this answer too.
     *
     *
     */

    public static void main(String[] args) {
        String str1 = "ABAB";
        int k1 = 2;
        String str2 = "AABABBA";
        int k2 = 1;
        int result = longestRepeatingCharReplacement(str2, k2);
        System.out.println("Longest Repeating Character Replacement "+result);
    }

    /**
     * Meaning of each variable
     * left       -> start of sliding window
     * right      -> end of sliding window
     * freq[]     -> frequency of characters in current window
     * maxFreq    -> highest frequency of ANY single character seen so far
     * windowSize -> right - left + 1
     * diff       -> how many chars we need to replace
     * max        -> best (longest) valid window found
     *
     * replacements needed = window size - frequency of most common char
     */

    private static int longestRepeatingCharReplacement(String s, int k){
        int left = 0, max = 0, n = s.length(), maxFreq = 0;
        int[] freq = new int[26];
        for(int right = 0; right < n; right++){
            char ch = s.charAt(right);
            freq[ch - 'A']++;
            //maximum frequency of a single character
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);
            int windowSize = right - left +1;
            int diff = windowSize - maxFreq;
            //shrink the array
            while(diff > k){
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++;
                windowSize = right - left +1;
                diff = windowSize - maxFreq;
            }
            int len = right - left + 1;
            max = Math.max(len, max);
        }
        return max;
    }
}
