package dev.nila.coding.problems.logicalassessment;

public class Practice2 {

    public static void main(String[] args) {

        question4();
        question3();
        question2();
        question1();
    }

    private static void question4(){
        /**
         * Given an array {7, 5, 8, 3, 1, 4} – write a simple program in Java that will return the largest 3 numbers.
         *
         * One approach is to sort the array and return the last three elements.
         * Another approach is to iterate through the array once and keep track of the three largest numbers.
         */

        int[] arr = new int[] {7, 5, 8, 3, 1, 4};
        int first = 0, second = 0, third = 0;
        for(int num : arr){
            if(num > first){
                third = second;
                second = first;
                first = num;
            }else if(num > second){
                third = second;
                second = num;
            }else if(num > third){
                third = num;
            }
        }
        System.out.println("Largest three elements "+first+" "+second+" "+third);
    }


    private static void question3(){
        /**
         * There are 20 questions on a test. You gain 10 points for each correct answer, and lose 5 points for each incorrect answer.
         * Someone answers all the questions and gets 125 points. How many questions did they get wrong?
         *
         * First I calculate the maximum score if all answers are correct, which is 200.
         * Then I compare it with the actual score 125, so 75 points were lost for totally.
         * Finally each wrong answer causes a 15-point loss, so 75 divided by 15 gives 5 wrong answers.
         */
        int totalCorrectPoints = 20 * 10;
        int score = 125;
        int totalLossPoints = totalCorrectPoints - score;
        int wrongPointsPerAnswer = 10 + 5;
        int totalWrongAnswers = totalLossPoints / wrongPointsPerAnswer;
        System.out.println("Total wrong answers: "+totalWrongAnswers);
    }


    private static void question2(){
        /**
         * Split 110 into two parts, so that one part is 150% of the other.
         * What are the two numbers?
         *
         * First,I assume the smaller number is x and the other number is 150% of x which is (1.5x).
         * Their total is 110, so the equation becomes x + 1.5x = 110.
         * That means 2.5x = 110, and dividing 110 by 2.5 gives x = 44.
         * Finally, the other number is 1.5 × 44, which equals 66.
         *
         * I assumed the smaller number is x and the larger number is 150% of x (1.5x).
         * Since their total is 110, the equation becomes x + 1.5x = 110. Solving it gives x = 44, and the other number is 66.
         */
        double smallerNumber = 110 /2.5;
        double otherNumber = 1.5 * smallerNumber;
        System.out.println("Smaller Number: "+smallerNumber);
        System.out.println("Larger Number: "+otherNumber);

    }

    private static void question1(){
        /**
         * From 300 to 399, how many 3 can you find? Please explain your answer.
         *
         * First, Numbers from 300 to 399 always contain a 3 in the hundreds digit, so that gives 100.
         * The digit 3 also appears 10 times in the tens place and 10 times in the units place,
         * so the total number of digit 3 occurrences is 120.
         *
         * First, every number between 300 and 399 has a 3 in the hundreds place,  that gives 100 occurrences.
         * Then I check the tens and units places which add 10 occurrences each.
         * Finally, the total number of digit 3 occurrences is 120.
         */
        int counter = 0;
        for(int i = 300; i <= 399; i++){
            int n = i;
            while(n !=0){
                if(n % 10 == 3) counter++;
                n /= 10;
            }
        }
        System.out.println("3 Digits count from 300 to 399: "+counter);
    }
}
