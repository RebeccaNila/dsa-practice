package dev.nila.coding.problems.numbers;

import java.util.List;
import java.util.ArrayList;

public class Fibonacci {

    //Q.Write a function to calculate the Fibonacci sequence up to a given number.
    public static void main(String[] args) {
        int n =50;
        List<Integer> result = generateFibonacci(n);
        System.out.println("Fibonacci Sequence "+result.toString());
        generateFibonacciSpaceOptimized(n);
    }

    private static void generateFibonacciSpaceOptimized(int n){

        int a = 0, b = 1;

        while( a <= n){
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }

    }

    /**
     *   Time: O(n)
     *   Space: O(n)
     */
    private static List<Integer> generateFibonacci(int n){
        List<Integer> list = new ArrayList<>();
        int a = 0, b = 1;
        while( a <= n){
            list.add(a);
            int next = a + b;
            a = b;
            b = next;
        }
        return list;
    }

}
