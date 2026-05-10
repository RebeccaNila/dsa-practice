package dev.nila.coding.problems.logicalassessment;
import java.util.Arrays;
public class Practice {

    public static void main(String[] args) {
        questions7();
        questions4();
        questions3();
        questions2();
        questions1();
    }

    private static void questions7(){
        /**
         * How many multiples of 8 are between 100 and 175? Explain how you get the answer.
         */

        int counter = 0;
        System.out.print("Multiples of 8 are between 100 and 175:  ");
        for(int i = 100; i<=175; i++){
            if(i % 8 == 0) {
                System.out.print(i+" ");
                counter++;
            }
        }
        System.out.println("Multiples of 8 are between 100 and 175 total "+counter);
    }

    private static void questions6(){
        /**
         *
         *    class conditional {
         *       public static void main(String args[]) {
         *          int i = 20;
         *          int j = 55;
         *          int z = 0;
         *          z = i < j ? i : j; // ternary operator
         *          System.out.println("The value assigned is " + z);
         *       }
         *    }
         */
        //The value assigned is 20
    }

    public static void questions5(){
        /**
         * What are the values of x and y? x = 5; y = ++x;
         * ++x is a pre-increment operator, which increases the value of x before assignment.
         * So x becomes 6 first, and then y is assigned that value. Therefore both x and y are 6.
         */
    }

    public static void questions4(){
        /**
         * Given an array {7, 5, 8, 3, 1, 4} – write a simple program in Java that will return the largest 3 numbers.
         * First sort the array in ascending and then take the last three elements.
         */

        int[] arr = new int[]{7, 5, 8, 3, 1, 4};
        int n = arr.length;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Largest 3 numbers "+arr[n-1]+ " "+ arr[n-2]+" "+arr[n-3]);
        /**
         * I iterate through the array and keep track of the three largest numbers using three variables: first, second, and third.
         * Whenever I find a bigger number, I shift the previous values and update the largest numbers accordingly.
         */
        //First declare three int variable and set min value
        // and then loop through the array
        // then compare the value with three variable
        //if greater than set the value
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        for(int num : arr){
            if(num > first){
                third = second;
                second = first;
                first = num;
            }else if( num > second){
                third = second;
                second = num;
            }else if(num > third){
                third = num;
            }
        }
        System.out.println("Largest 3 elements "+first+ " "+ second+" "+third);
    }

    public static void questions3(){
        /**
         * There are 20 questions on a test. You gain 10 points for each correct answer, and lose 5 points for each incorrect answer.
         * Someone answers all the questions and gets 125 points. How many questions did they get wrong?
         *
         * If all 20 answers were correct, the score would be 200. The actual score is 125, so 75 points were lost.
         * Each wrong answer causes a loss of 15 points (10 missed + 5 penalty), so 75 divided by 15 gives 5 wrong answers.
         */
        int totalCorrectPoints = 20 * 10;
        int score = 125;
        int totalLossPoints = totalCorrectPoints - score;
        int lossPerQuestion = 10 + 5;
        int wrongQuestions = totalLossPoints / lossPerQuestion;
        System.out.println("Wrong Questions "+wrongQuestions);
    }

    public static void questions2(){

        /**
         * I assumed one number is x, and the other is 150% of x, which is 1.5x.
         * Since their total is 110, I formed the equation x + 1.5x = 110. Solving it gives x = 44,
         * so the other number is 66.
         *
         * First,I assume the smaller number is x and the other number is 150% of x which is (1.5x).
         * Their total is 110, so the equation becomes x + 1.5x = 110.
         * That means 2.5x = 110, and dividing 110 by 2.5 gives x = 44.
         * Finally, the other number is 1.5 × 44, which equals 66.
         *
         */
        double total = 110;
        //let the smaller number be x
        double smaller = total / 2.5;
        //larger number is 150 % of x
        double larger = 1.5 * smaller;
        System.out.println("Smaller number: "+smaller);
        System.out.println("Larger number: "+larger);

    }

    public static void questions1(){
        //I iterate through numbers from 300 to 399 and check each digit using modulo %10 and division /10.
        // Every time the digit equals 3, I increment a counter.
        /**
         *
         *
         * How it works
         *
         * Loop through numbers 300 → 399.
         *
         * For each number:
         *
         * Use % 10 to get the last digit.
         *
         * Check if it equals 3.
         *
         * If yes → increase the counter.
         *
         * Use / 10 to remove the last digit and continue checking.
         */
        int counter = 0;
        for(int i=300; i<=399; i++){
            int n = i;
            while(n != 0){
                if(n % 10 == 3 ) counter++;
                n /= 10;
            }
        }
        System.out.println("Find 3 digits occurrences between 300 and 399 "+counter);

    }
}
