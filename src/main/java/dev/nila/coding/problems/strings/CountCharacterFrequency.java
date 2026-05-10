package dev.nila.coding.problems.strings;

import java.util.Map;
import java.util.HashMap;

public class CountCharacterFrequency {

    public static void main(String[] args) {
        String str = "aabccc";
        countCharacterFrequency(str);
    }

    private static void countCharacterFrequency(String str){
        Map<Character, Integer> map = new HashMap<>();
        for(Character ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        System.out.println(map.toString());

    }
}
