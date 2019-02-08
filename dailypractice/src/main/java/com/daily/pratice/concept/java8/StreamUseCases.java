package com.daily.pratice.concept.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class StreamUseCases {

    public static void main(String[] args ){

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Trader> traders = Arrays.asList(
        new Trader("Raoul", "Cambridge"),
        new Trader("Mario","Milan"),
        new Trader("Alan","Cambridge"),
        new Trader("Brian","Cambridge"));

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //Find all transactions in the year 2011 and sort them by value (small to high).
        System.out.println(transactions.stream().filter(transaction -> transaction.getYear()==2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList()));

        //What are all the unique cities where the traders work?
        System.out.println(transactions.stream().map(transaction -> transaction.getTrader().getCity()).collect(toSet()));

        // Find all traders from Cambridge and sort them by name.
        System.out.println("Find all traders from Cambridge and sort them by name.");
        System.out.println(traders.stream().filter(trader -> trader.getCity().equals("Cambridge")).map(trd -> trd.getName()).sorted().collect(Collectors.toList()));
        System.out.println(transactions.stream().map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toSet()));

        //Return a string of all traders’ names sorted alphabetically.
        System.out.println("Return a string of all traders’ names sorted alphabetically.");
        List<String> allTraderNames = traders.stream().map(trd -> trd.getName()).sorted().collect(Collectors.toList());
        System.out.println(allTraderNames);

        // Are any traders based in Milan?
        System.out.println("Are any traders based in Milan?");
        if( traders.stream().filter(trader -> trader.getCity().equals("Milan")).findAny().isPresent()) {
            System.out.println("Yes, some trader(s) is based in Milan");
        }
        else {
            System.out.println("No trader(s) is based in Milan");
        }

        //Print all transactions’ values from the traders living in Cambridge.
        System.out.println("Print all transactions’ values from the traders living in Cambridge.");
        System.out.println(transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).map(tran->tran.getValue()).collect(toList()));

        // What’s the highest value of all the transactions?
        System.out.println("What’s the highest value of all the transactions?");
        System.out.println(transactions.stream().map(transaction -> transaction.getValue()).reduce(0,(a,b)-> a>b?a:b));

        // Find the transaction with the smallest value.
        System.out.println("What’s the lowest value of all the transactions?");
        System.out.println(transactions.stream().map(Transaction::getValue).reduce(1,(a,b)-> a<b?a:b));



    }
}
