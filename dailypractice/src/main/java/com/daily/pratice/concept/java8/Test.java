package com.daily.pratice.concept.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Executors;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Test {

    public static void main( String[]  args ) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };
        Comparator<String> comparatorLambda = ( String o1, String o2 ) -> Integer.compare(o1.length(), o2.length());

        System.out.println(comparator.compare("yash", "tanuj"));

        String[] arr = new String[]{"zebra", "lion", "monkey", "panther", "chitah", "lovebirds", "jiraffe"};
        Arrays.sort(arr, comparator);
        System.out.println(Arrays.asList(arr));

        Runnable runner = new Runnable() {
            public void run() {
                for( int i = 0; i < 4; i++ ) {
                    System.out.println("Print me");
                }
            }
        };
        Executors.newSingleThreadExecutor().execute(runner);
        // keep curly braces if more than one lines of code.
        Runnable runner1 = ()-> { for( int i = 0; i < 4; i++ ) {
            System.out.println("Print me");
        }
    };
        Executors.newSingleThreadExecutor().execute(runner1);

        Comparator<String> comparator3 = (String s1, String s2 ) -> {
                System.out.println ( "I am comparing strings") ;
                return Integer.compare(s1.length(), s2.length());
        };
        Arrays.sort(arr, comparator3);
        System.out.println(Arrays.asList(arr));

        BinaryOperator<Integer> addition = (s1, s2) -> ( s1 + s2 );

        // (s1, s2) -> ( Integer.sum(s1, s2 );
       // BinaryOperator<Integer> addition1 =  Integer::addition1;
        Predicate<String> pred = new Predicate<String>() {
            public boolean test( String s1) {
                return s1.length() < 20;
            }
        };

        Predicate<String> predLambda = (s1)->s1.length()<20;

        System.out.println( pred.test("Lambda Expressions"));
        System.out.println( predLambda.test("Lambda Expressions"));

    }
}
