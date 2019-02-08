package com.daily.pratice.concept.java8;
import com.daily.pratice.concept.java8.Dish;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final class Menu {
    public static void main( final String args[] ){
        //create a list of menu items
        List<Dish> menu = Arrays.asList(
                new Dish("pork",false,800,Dish.Type.MEAT),
                new Dish("beef",false,700,Dish.Type.MEAT),
                new Dish("chicken",false,400,Dish.Type.MEAT),
                new Dish("french fries",true,530,Dish.Type.OTHER),
                new Dish("rice",true,350,Dish.Type.OTHER),
                new Dish("season fruit",true,120,Dish.Type.OTHER),
                new Dish("pizza",true,550,Dish.Type.OTHER),
                new Dish("prawns",false,300,Dish.Type.FISH),
                new Dish("salmon",false,450,Dish.Type.FISH)
        );
        // create a list of high calorie dishes
        List<String> highCalorieDishes = menu.stream().filter(dish -> dish.getCalories() > 300 ).map(Dish::getName).limit(3).collect(toList());
        System.out.println(highCalorieDishes);
        System.out.println( menu.parallelStream().map(Dish::getCalories).collect(toList()));

        //print each word of a list
        List<String> words = Arrays.asList("Mercury","Venus","Earth","Mars","Saturn","Jupiter","Moon","Pluto");
        Stream s = words.stream();
        s.forEach(System.out::println);

        // print name of each dish on the menu
        System.out.println( menu.stream().map(dish -> dish.getName()).collect(Collectors.toList()));

        //debug lines in lambda expression
        List<String> highCalDishes = menu.stream()
                .filter( dish-> {
                                    System.out.println("Filtering dish " +dish.getName());
                                    return dish.getCalories() > 300;
                                })
                .map(dish -> {
                                    System.out.println("Mapping dish " +dish.getName());
                                    return dish.getName();
                                })
                .limit(3).collect(toList());
        System.out.println(highCalDishes);

        //filter method takes a predicate as a parameter and prints only those values that match predicate.
        System.out.println(menu.stream().filter(dish -> dish.isVegetarian()).collect(toList()));

        //print distinct numbers
        List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,2,4,6);
        ints.stream().filter(i->i%2==0).distinct().forEach(System.out::println);

        //skip some elements from a stream
        List<String> strings = Arrays.asList("One","Two","Three","Four","Five","Six");
        strings.stream().skip(3).forEach(System.out::println);

        //map - select information from certain objects similar to how we can select a column from a given table.

        //extract dish names from menu
        System.out.println( menu.stream().map(Dish::getName).map(String::length).collect(toList()));

        //given a list of strings, give length of each string
        System.out.println(words.stream().map(String::length).collect(toList()));

        // given a list of strings - return a list of unique characters from the list.
        List<String> distinctChars = Arrays.asList("Hello", "World");
        System.out.println(distinctChars.stream().map(String::toCharArray).distinct().collect(toList())); // this does not work
        System.out.println("******"+distinctChars.stream().map(word->word.split("")).distinct().collect(toList()));// this does not work

        List<String> myList = distinctChars.stream()
                     .map(w->w.split(""))
                     .flatMap(Arrays::stream)
                     .distinct()
                .collect(Collectors.toList());
        System.out.println("&&&&&" +myList);

        // given a list of numbers - return a list of square of each number
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
        System.out.println(numbers.stream().map(num->num*num).collect(toList()));

        //given two lists of numbers, how will you return a pair
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(5,6);
        List<int[]> pairs = list1.stream()
                            .flatMap(i -> list2.stream()
                                        .map(j-> new int[]{i,j})).collect(toList());

        System.out.println(pairs);
        List<int[]> divBy3 = (list1.stream()
                .flatMap(i -> list2.stream()
                .filter(j->(i+j)%3==0)
                .map(j-> new int[]{i,j}))
                .collect(toList()));

        // does the menu have a vegetarian option.
        // anyMatch returns a boolean and is therefore a terminal operation.
        if ( menu.stream().anyMatch(Dish::isVegetarian) ) {
            System.out.println(menu.stream().filter(Dish::isVegetarian).map(Dish::getName).collect(toList()));
        }
        //allMatch - find if all dishes are less than 1000 cal
        if( menu.stream().allMatch(d->d.getCalories() < 1000)) {
            System.out.println("It is a healthy menu");
        }

        // use of Optional class and findAny and ifPresent.
         menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(dish -> System.out.println(dish.getName()));

        //findFirst
        List<Integer> someNumbers = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println( someNumbers.stream().map(p->p*p).filter(p->p%3==0).findFirst());

        //sum all numbers in a given list
        System.out.println(someNumbers.stream().reduce(0,(a,b)->a+b));

        //multiply all numbers in a given list
        System.out.println(someNumbers.stream().reduce(1,(a,b)->a*b));

        //calculate maximum and minumum elements in a stream
        System.out.println(someNumbers.stream().reduce(1,(a,b)-> a < b ? a:b));
        System.out.println(someNumbers.stream().reduce(1,(a,b)-> a > b ? a:b));
        //Using Integer methods
        System.out.println(someNumbers.stream().reduce(1,Integer::max));
        System.out.println(someNumbers.stream().reduce(1,Integer::min));

        //count number of dishes in a menu using map and reduce functions
        //map each dish on menu to a number 1 and then sum all the numbers.
        System.out.println( menu.stream().map(dish -> 1).reduce(0,(a,b)->a+b) );

        System.out.println(menu.stream().mapToInt(Dish::getCalories).sum());


    }
}
