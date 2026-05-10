package dev.nila.coding.problems.strings;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class FindFirstNonRepeatedCharacter {

    public static void main(String[] args) {
        String str = "swiss";
        Character result = findFirstNonRepeatedCharacter(str);
        System.out.println("FindFirstNonRepeatedCharacter "+result);
    }

    private static Character findFirstNonRepeatedCharacter(String str){
        Character result = null;
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(Character ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                result = entry.getKey();
                break;
            }
        }
        return result;
    }
}
