package com.daily.pratice.concept.java8;

public class TestPredicate {

    public static void main( String[] args ) {
        CustomPredicate<String> customPredicate = (s) -> s.contains("jar");
        boolean b = customPredicate.test("ajar");
        System.out.println(b);

        //chaining of predicates.
        CustomPredicate<String> customPredicate1 = (s) -> s.length() > 20;
        CustomPredicate<String> customPredicate2 = (s) -> s.length() < 5;

        CustomPredicate<String> customPredicate3 = customPredicate1.and(customPredicate2);


    }
}
