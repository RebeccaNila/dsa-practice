package dev.nila.leetcode.medium;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FindAllAnagramsString438 {


    /**
     * https://leetcode.com/problems/find-all-anagrams-in-a-string/
     *
     * Given two strings s and p,
     * return an array of all the start indices of p's anagrams in s.
     * You may return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "cbaebabacd", p = "abc"
     * Output: [0,6]
     * Explanation:
     * The substring with start index = 0 is "cba", which is an anagram of "abc".
     * The substring with start index = 6 is "bac", which is an anagram of "abc".
     *
     * Example 2:
     * Input: s = "abab", p = "ab"
     * Output: [0,1,2]
     * Explanation:
     * The substring with start index = 0 is "ab", which is an anagram of "ab".
     * The substring with start index = 1 is "ba", which is an anagram of "ab".
     * The substring with start index = 2 is "ab", which is an anagram of "ab".
     */

    public static void main(String[] args) {
        String s1 = "cbaebabacd";
        String s2 = "abc";
        String s3 = "abab";
        String s4 = "ab";
        List<Integer> result = findAnagramsOptimized(s1, s2);
        System.out.println("Find All Anagrams String "+result);

    }

    private static List<Integer> findAnagramsOptimized(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;
        int left = 0, n=s.length(), count = p.length(), right = 0;
        int[] freq = new int[26];
        //How many more of this character do I still need?” 'freq'
        //How many total characters am I still missing? 'count'
        //Expand window → reduce missing
        //Shrink window → add back missing
        //count == 0 “I am missing nothing → perfect anagram”
        for(char ch : p.toCharArray()){
            freq[ch - 'a']++;
        }
        while(right < n) {
            if (freq[s.charAt(right) - 'a'] > 0) count--;
            freq[s.charAt(right) - 'a']--;
            right++;
            if (count == 0) result.add(left);
            if (right - left == p.length()){
                if (freq[s.charAt(left) - 'a'] >= 0) count++;
                freq[s.charAt(left) - 'a']++;
                left++;
            };

        }
        return result;
    }

    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;
        int left = 0, n=s.length(), pSize = p.length();
        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

//        for(int i=0; i<pSize; i++){
//            pFreq[p.charAt(i) - 'a']++;
//        }

        for(char ch : p.toCharArray()){
            pFreq[ch - 'a']++;
        }

        for(int right =0; right<n; right++){
            windowFreq[s.charAt(right) - 'a']++;
            while(right - left +1 >pSize){
                windowFreq[s.charAt(left)  - 'a']--;
                left++;
            }
            if(Arrays.equals(pFreq, windowFreq)){
                result.add(left);
            }
        }
        return result;
    }
}
