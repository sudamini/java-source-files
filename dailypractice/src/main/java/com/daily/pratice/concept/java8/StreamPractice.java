package com.daily.pratice.concept.java8;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.*;

final class StreamPractice {

    public static void main(final String[] args ) {

        // different ways to create streams
        List<Person> peopleList = new ArrayList<>();
        Stream<Person> people = peopleList.stream();
        Stream emptyStream = Stream.empty();
        Person person = new Person();
        Stream.of(person); // builds stream of only one element
        Stream.of("one","two","three");

        Stream.generate( () -> "one");
        System.out.println(ThreadLocalRandom.current().ints());
    }
    private static class Person {
        String name;
        String age;
    }
}
