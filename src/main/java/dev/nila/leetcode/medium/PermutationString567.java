package dev.nila.leetcode.medium;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class PermutationString567 {

    /**
     * https://leetcode.com/problems/permutation-in-string/description/
     *
     * Given two strings s1 and s2,
     * return true if s2 contains a permutation of s1, or false otherwise.
     * In other words, return true if one of s1's permutations is the substring of s2.
     *
     * Example 1:
     *
     * Input: s1 = "ab", s2 = "eidbaooo"
     * Output: true
     * Explanation: s2 contains one permutation of s1 ("ba").
     *
     * Example 2:
     * Input: s1 = "ab", s2 = "eidboaoo"
     * Output: false
     *
     * A permutation is a rearrangement of all the characters of a string.
     */

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        String s3 = "ab";
        String s4 = "eidboaoo";
        boolean result = checkInclusionOptimized(s3, s4);
        System.out.println("Permutation in String "+result);
    }

    public static boolean checkInclusionOptimized(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {
            freq2[s2.charAt(right) - 'a']++;

            if (right - left + 1 > s1.length()) {
                freq2[s2.charAt(left) - 'a']--;
                left++;
            }

            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        boolean result = false;
        int left = 0, n1 = s1.length(), n2 = s2.length();
        for(int i=0; i<n1; i++){
            Character ch = s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0)+1);
        }

        for(int right =0; right<n2; right++){
            Character ch = s2.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0)+1);

            while((right - left +1) > n1){
                Character leftCh = s2.charAt(left);
                window.put(leftCh, window.get(leftCh)-1);
                if(window.get(leftCh) == 0) window.remove(leftCh);
                left++;
            }
            if(map1.equals(window)) return true;
        }
        return false;
    }
}
