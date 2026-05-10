package dev.nila.coding.problems.strings;

public class PalindromeChecker {
    //Q.Write a function that checks whether a given string is a palindrome or not?
    public static void main(String[] args) {
        String str = "level";
        boolean result = isPalindrome(str);
        System.out.println("Is Palindrome: "+result);
    }
    private static boolean isPalindrome(String str){
        if(str == null) return false;
        int n = str.length();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = n-1; i>=0; i--){
            stringBuilder.append(str.charAt(i));
        }
        //compare strings and return true or false
        return (str.equals(stringBuilder.toString())) ? true : false;
    }
}
