package dev.nila;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;

public class AnagramGrouper {

    /**
     * Time Limit: 30 Minutes Task: Write a complete Java method to solve the following.
     *
     * Problem: "Group Anagrams" Given an array of strings, group the anagrams together. You can return the answer in any order.
     *
     * Input: ["eat","tea","tan","ate","nat","bat"]
     *
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * Constraints:
     *
     * Input is never null.
     *
     * Strings consist of lowercase English letters.
     *
     * Hint: How can you generate a unique "key" for words that are anagrams of each other?
     * (e.g., sorting the letters of "eat" becomes "aet").
     *
     * Time Complexity: O(N . K log K)
     * N is the number of words.K is the max length of a word.
     * Sorting each word takes K log K.
     * We do this N times.
     * Space Complexity: O(N . K) to store the map results.
     */

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("eat","tea","tan","ate","nat","bat"));
        List<List<String>> result = anagramGrouper(stringList);
        System.out.println(result);
    }

    private static List<List<String>> anagramGrouper(List<String> stringList){

        if(stringList == null){
            return new ArrayList<>();
        }

        if(stringList.isEmpty()){
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for(String str: stringList){
            // 1. Convert string to char array to sort it
            char[] characters = str.toCharArray();
            Arrays.sort(characters);

            // 2. Create the unique key
            String key = new String(characters);

            // 3. Add to map
            // If key doesn't exist, create a new empty list
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

//            // 4. Add the original word to the list for that key
//            map.get(key).add(str);
//
//            // YOUR CODE (Java 7 Style)
//            if(!map.containsKey(key)){
//                map.put(key, new ArrayList<>());
//            }
//            map.get(key).add(str);
//
//            // SENIOR CODE (Java 8 Style)
//            // "If the key is missing, create a new ArrayList, put it in the map, and return it. Then add 'str'."
//            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);

        }
        // Return just the lists (the values of the map)
        return new ArrayList<>(map.values());
    }
}
