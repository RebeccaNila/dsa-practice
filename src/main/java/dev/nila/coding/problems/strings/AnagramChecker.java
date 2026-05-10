package dev.nila.coding.problems.strings;
import java.util.Arrays;
public class AnagramChecker {
    //Q.Write a function that checks whether two strings are anagrams or not?

    public static void main(String[] args) {
        String str1 = "listen", str2 = "slient";
        boolean result = areAnagram(str1, str2);
        System.out.println("Is Anagram: "+result);
    }
    private static boolean areAnagram(String str1, String str2){
        //Convert strings to character arrays and sort them
        if(str1.length() != str2.length()) return false;
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();

        Arrays.sort(charArr1);
        Arrays.sort(charArr2);
//        System.out.println("String 1 "+charArr1.toString());
//        System.out.println("String 2 "+charArr2.toString());
        //Compare sorted character arrays
        return Arrays.equals(charArr1, charArr2);
    }
}
