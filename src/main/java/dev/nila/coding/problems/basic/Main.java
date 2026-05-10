package dev.nila.coding.problems.basic;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        countTheNoWords("Hi There Hi Hello There");
        swapNumbers(5, 8);

    }

    private static void countTheNoWords(String input){
        Map<String, Integer> map = new HashMap<>();
        String[] words = input.split("\\s+");
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for(Map.Entry<String, Integer> entry:  map.entrySet()){
            System.out.println(entry.getKey()+" -> "+ entry.getValue());
        };
        map.forEach((key, value)->
                System.out.println("key "+key+" value "+value));

    }

    private static void swapNumbers(int a, int b){
        a = a+b;
        b = a - b;
        a = a - b;
        System.out.println("After swap a "+a+" b "+b);
    }


}
