package com.daily.pratice.concept.java8;

import java.util.ArrayList;
import java.util.List;
/** A test class to try out new Collection enhancements in Java8
 */

public class CollectionLambdas {

    public static void main( String[] args ) {

        List<Person> personList = new ArrayList<>();
        Person one = new Person(10,"abc","jain");
        Person two = new Person(20,"xyz","joshi");
        Person three = new Person(30,"mno","mahadev");
        personList.add(one);
        personList.add(two);
        personList.add(three);
        personList.forEach(System.out::println);

        personList.removeIf(person -> person.age < 20 );
        personList.forEach(System.out::println );

        List<String> names = new ArrayList<>();
        names.add("john doe");
        names.add("sally smith");
        names.add("mark jacob");
        names.add("kate winslet");
        //Unary operator
        names.replaceAll(name -> name.toUpperCase());


    }

    private static class Person {
        int age;
        String firstName;
        String lastName;

        Person(int age, String first, String last ) {
            this.age = age;
            this.firstName = first;
            this.lastName = last;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

}
