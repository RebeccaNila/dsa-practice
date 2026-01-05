package dev.nila.geeksforgeeks.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstrKUniques {

    /**
     * Links: https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
     *
     * You are given a string s consisting only lowercase alphabets and an integer k.
     * Your task is to find the length of the longest substring that contains exactly k distinct characters.
     *
     * Note : If no such substring exists, return -1.
     * Examples 1:
     * Input: s = "aabacbebebe", k = 3
     * Output: 7
     * Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
     *
     * Examples 2:
     * Input: s = "aaaa", k = 2
     * Output: -1
     * Explanation: There's no substring with 2 distinct characters.
     *
     * Examples 3:
     * Input: s = "aabaaab", k = 2
     * Output: 7
     * Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.
     */

    public static void main(String[] args) {
        String str1 = "aabacbebebe";
        int k1 = 3;
        String str2 = "aaaa";
        int k2 = 2;
        String str3 = "aabaaab";
        int k3 = 2;
        int result = longestSubstringKUniques(str3, k3);
        System.out.println("Longest Substring with K Uniques "+result);
    }

    private static int longestSubstringKUniques(String s, int k){
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, res = -1, n = s.length();
        for(int right = 0; right < n; right++){
            char ch = s.charAt(right);
            //oldway
//            if(map.containsKey(ch)){
//                map.put(s.charAt(right), map.get(ch)+1);
//            }else{
//                map.put(s.charAt(right), 1);
//            }
            //newWay
            map.put(ch, map.getOrDefault(ch, 0)+1);
            // shrink window if more than k unique
            while(map.size() > k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar)-1);
                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                left++;
            }
            if(map.size() == k){
                int currentLen = right - left + 1;
                res = Math.max(currentLen, res);
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
        return res;
    }
}
