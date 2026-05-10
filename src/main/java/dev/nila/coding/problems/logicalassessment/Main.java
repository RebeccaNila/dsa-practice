package dev.nila.coding.problems.logicalassessment;

public class Main {

    public static void main(String[] args) {
        System.out.println("3 digits count in 300 to 399 "+question1());
    }

    private static int question1(){
        //From 300 to 399, how many 3 can you find? Please explain your answer.
        /** Numbers from 300 to 399 always contain a 3 in the hundreds digit,
         * so that gives 100.
         * The digit 3 also appears 10 times in the tens place and 10 times in the units place,
         * so the total number of digit 3 occurrences is 120.
         *
         * I looped through numbers 300 to 399 and checked each digit using modulo %10.
         * Whenever the digit equals 3, I increased the counter. Finally, the total count is 120.
         */
        int count = 0;
        for (int i = 300; i <= 399; i++) {
            int n = i;

            while (n != 0) {
                if (n % 10 == 3) {
                    count++;
                }
                n /= 10;
            }
        }

        return count;
    }
}
