package dev.nila.coding.problems.logicalassessment;

public class Practice3 {

    public static void main(String[] args) {
        question7();
        question3();
        question2();
        question1();
    }

    private static void question7(){
        /**
         * How many multiples of 8 are between 100 and 175? Explain how you get the answer.
         */
        int counter = 0;
        for(int i =100; i<=175; i++){
            if(i %8 == 0){
                System.out.println(i);
                counter++;
            }
        }
        System.out.println("Total value multiples of 8 between 100 and 175 "+counter);

    }

    private static void question3(){
        /**
         * There are 20 questions on a test. You gain 10 points for each correct answer, and lose 5 points for each incorrect answer.
         * Someone answers all the questions and gets 125 points. How many questions did they get wrong?
         */

        int maxScore = 20 * 10;
        int actualScore = 125;
        int totalLossPoints = maxScore - actualScore;
        int lossPointsPerQuestion = 10 + 5;
        int totalWrongQuestions = totalLossPoints / lossPointsPerQuestion;
        System.out.println("Wrong Questions: "+totalWrongQuestions);
    }

    private static void question2(){
        /**
         * Split 110 into two parts, so that one part is 150% of the other.
         * What are the two numbers?
         */
        int total = 110;
        double smaller = total / 2.5;
        double larger =smaller * 1.5;
        System.out.println("Smaller Number: "+(int) smaller);
        System.out.println("Larger Number: "+(int) larger);
    }

    private static void question1(){

        /**
         * From 300 to 399, how many 3 can you find? Please explain your answer.
         */
        int counter = 0;
        for(int i=300; i<=399; i++){
            int num = i;
            while(num !=0 ){
                if(num %10 == 3) counter++;
                num /= 10;
            }
        }
        System.out.println("The total number of digit 3 occurrences: "+counter);
    }
}
