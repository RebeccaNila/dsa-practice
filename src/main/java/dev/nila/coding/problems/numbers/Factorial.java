package dev.nila.coding.problems.numbers;

public class Factorial {

    //Q.Write a function to calculate the factorial of a number.

    public static void main(String[] args) {
        int number = 5;
        long result = calculateFactorial(number);
        System.out.println("Factorial "+result);
    }

    private static long calculateFactorial(int num){
        long multiplication = 1; // set initial value
        while(num >= 1){
            multiplication = multiplication*num;
            num--;
        }
        return multiplication;
    }
}
