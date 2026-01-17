package dev.nila.leetcode.easy;

public class ValidPalindrome125 {

    /**
     * https://leetcode.com/problems/valid-palindrome/description/
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
     * and removing all non-alphanumeric characters, it reads the same forward and backward.
     * Alphanumeric characters include letters and numbers.
     *
     * Given a string s, return true if it is a palindrome, or false otherwise.
     *
     * Example 1:
     *
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     * Example 2:
     *
     * Input: s = "race a car"
     * Output: false
     * Explanation: "raceacar" is not a palindrome.
     * Example 3:
     *
     * Input: s = " "
     * Output: true
     * Explanation: s is an empty string "" after removing non-alphanumeric characters.
     * Since an empty string reads the same forward and backward, it is a palindrome.
     */

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = "  ";
        boolean result = isPalindrome(s3);
        System.out.println("Is Palindrome : "+result);
    }

    private static boolean isPalindrome(String s){
        /**
         * 1. Convert all the characters to lower case s.toLowerCase();
         * 2. Remove all the non-alphanumeric characters from the string s.replaceAll("[^a-z0-9]","");
         * 3. Loop and check two pointers until both index are same
         */
        if (s.isEmpty()) return false;
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]","");
        int n = s.length();
        for(int i = 0; i<n/2; i++){
            if(s.charAt(i) != s.charAt(n-1-i))
                return false;
        }
        return true;
    }
}
