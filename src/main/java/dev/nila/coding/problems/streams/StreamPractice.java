package dev.nila.coding.problems.streams;

import java.util.List;
import java.time.LocalDate;
import java.util.stream.*;
import java.util.Map;
import java.util.Comparator;
import java.util.Optional;
import java.util.Collections;

// Using Java Records for clean, modern data models
record Transaction(
        String txnId,
        String accountId,
        double amount,
        String currency,
        String status, // "SUCCESS", "FAILED", "PENDING"
        LocalDate date,
        String merchantCategory // "GROCERY", "UTILITIES", "ENTERTAINMENT", "TRANSFER"
) {}
public class StreamPractice {
    private static List<Transaction> transactions;
    public static void main(String[] args) {
        transactions = List.of(
                new Transaction("TXN001", "ACC123", 1200.50, "USD", "SUCCESS", LocalDate.now(), "TRANSFER"),
                new Transaction("TXN002", "ACC456", 50.00, "USD", "FAILED", LocalDate.now().minusDays(1), "GROCERY"),
                new Transaction("TXN003", "ACC123", 450.00, "EUR", "SUCCESS", LocalDate.now().minusDays(2), "ENTERTAINMENT"),
                new Transaction("TXN004", "ACC789", 2500.00, "USD", "SUCCESS", LocalDate.now().minusDays(3), "TRANSFER"),
                new Transaction("TXN005", "ACC456", 99.99, "USD", "PENDING", LocalDate.now(), "UTILITIES"),
                new Transaction("TXN006", "ACC123", 15.00, "EUR", "SUCCESS", LocalDate.now(), "GROCERY"),
                new Transaction("TXN007", "ACC789", 120.00, "INR", "SUCCESS", LocalDate.now().minusDays(1), "UTILITIES")
        );
        findFrequencyOfElements();
        System.out.println("----------------------------------------");
        question5();
        question4();
        question3();
        question2();
        question1();
    }
    /**
     * 2. Find Duplicate Elements
     * Question: "Find only the items that appear more than once in a list."
     * Memorize this: Use Collections.frequency inside a .filter().
     */
    private static void findDuplicateElements(){
//        List<String> status = transactions.stream()
//                .filter( t -> Collections.frequency(t., t.status()))
//                .distinct()
//                .toList();
    }

    /**
     * 1. Find Frequency of Elements (The #1 Most Asked)
     * Question: "Given a list of strings or characters, count how many times each one appears."
     * Memorize this: Collectors.groupingBy + Collectors.counting()
     */
    private static void findFrequencyOfElements(){
        Map<String, Long> statusCounts = transactions.stream()
                .collect(Collectors.groupingBy(
                        t -> t.status(),
                        Collectors.counting()
                ));
        System.out.println(statusCounts);
    }
    /**
     * Question 5: Advanced Multi-Level Collection
     * Problem: For each account ID, get the total amount spent on successful transactions.
     */
    private static void question5(){
        Map<String, Double> totalSpentByAccount = transactions.stream()
                .filter(t -> "SUCCESS".equals(t.status()))
                .collect(Collectors.groupingBy(
                        Transaction::accountId, Collectors.summingDouble(Transaction::amount)
                ));

        System.out.println("Spending Profile by Account: "+ totalSpentByAccount);
    }


    /**
     * Question 4: Sorting & Finding Extremes (Java 21 Sequenced Collections integration)
     * Problem: Find the single highest amount transaction that was successful.
     */
     private static void question4(){
        Optional<Transaction> highestTxn = transactions.stream()
             .filter(t -> "SUCCESS".equals(t.status()))
             .max(Comparator.comparing(Transaction::amount));
       // "Highest Txn: " + t.txnId() + " for amount " + t.amount())
        highestTxn.ifPresent(t -> System.out.println("Highest Txn: " + t.txnId() + " for amount " + t.amount()));

    }
    /**
     * Question 3: Summing and Reducing Data
     * Problem: Calculate the total amount of all successful transactions processed in USD.
     */

    private static void question3(){
        double totalSuccessAmount = transactions.stream()
                .filter(t -> "SUCCESS".equals(t.status()) && "USD".equals(t.currency()))
                .mapToDouble(Transaction::amount)
                .sum();
        System.out.println("Total Successful USD Volume: $ "+totalSuccessAmount);

    }



    /**
     * Question 2: Grouping / Aggregation (The "L3 Favorite")
     * Problem: Group the transactions by their status so support teams can see lists of successful vs failed vs pending records.
     */

    private static void question2(){
        Map<String, List<Transaction>> tranStatus = transactions.stream()
                .collect(Collectors.groupingBy(t -> t.status()));
        tranStatus.forEach((status, list) -> {
            System.out.println("Status "+status + " count: "+list.size());
        });
    }

    /**
     * Question 1: Basic Filtering and Mapping
     * Problem: Find the transaction IDs of all successful transactions with an amount greater than 100 USD.
     */
    private static void question1(){
        List<String> transIds = transactions.stream()
                .filter(t -> "SUCCESS".equals(t.status()) && "USD".equals(t.currency()) && t.amount() > 100)
                .map(Transaction::txnId)
                .toList(); // Modern Java 16+ short-hand instead of .collect(Collectors.toList())
        System.out.println("High Value USD Success IDs:  "+transIds);

    }

}
