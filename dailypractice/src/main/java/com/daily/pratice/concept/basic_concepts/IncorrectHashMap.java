package com.daily.pratice.concept.basic_concepts;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * This class shows what happens if you dont correctly override hashcode and equals
 */

final class IncorrectHashMap {

    public static void main (final String[] args ){
        Map<Integer,Person> integerPersonMap = new HashMap<>();

        Person person1 = new Person("Harry Potter", 100);
        Person person2 = new Person("Harry Potter", 100);
        Person person3 = new Person("Wizard of Oz", 200);
        Person person4 = new Person("Iron Man", 300);

        // two keys can have the same value. Map doesnt care.
        integerPersonMap.put(1,person1);
        integerPersonMap.put(2,person2);
        integerPersonMap.put(3,person3);
        integerPersonMap.put(4,person4);
        System.out.println( integerPersonMap);

        Map<Person,Integer> personIntegerMap = new HashMap<>();

        personIntegerMap.putIfAbsent(person1,1);
        personIntegerMap.putIfAbsent(person2,2);
        personIntegerMap.putIfAbsent(person3,3);
        personIntegerMap.putIfAbsent(person4,4);
        System.out.println(personIntegerMap);

        Town town1 = new Town("Jersey City", 100);
        Town town2 = new Town("Newark", 100);
        Town town3 = new Town("Edison", 500);
        Town town4 = new Town("Montclair", 500);

        Map<Town,Integer> townIntegerMap = new HashMap<>();
        townIntegerMap.put(town1,1);
        townIntegerMap.put(town2,2);
        townIntegerMap.put(town3,3);
        townIntegerMap.put(town4,4);
        System.out.println(townIntegerMap);
        //should return value = 1
        System.out.println(townIntegerMap.get(town1));

        Town town5 = new Town("New Orleans",5000);
        townIntegerMap.put(new Town("Montreal", 5000),5 );
        townIntegerMap.put(new Town("Boston", 5000),6 );
        townIntegerMap.put(town5,7);

        System.out.println(townIntegerMap);
        System.out.println(townIntegerMap.get(new Town("Boston",5000)));

    }
    /*
    This correctly overrides hashcode and equals
     */
    static class Person {
        String name;
        Integer id;

        public Person(String name, Integer id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return name.equals(person.name) &&
                    id.equals(person.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }

    /*
    This does not override hashcode and equals. So, it will get Object class's method definitions.
    equals() method will implement object reference equality, so hash map will contain duplicate keys. This will not provide any retrieval guarentee and break hashmap contract
     */
    static class Town {
        String name;
        Integer population;

        public Town(String name, Integer population) {
            this.name = name;
            this.population = population;
        }

        @Override
        // This is returning a constant value.
        // Rhis will slow down hashmap retrieval because many towns will map to same place as they can have same population
        public int hashCode() {
            return population;
        }

        @Override
        public String toString() {
            return "Town{" +
                    "name='" + name + '\'' +
                    ", population=" + population +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Town town = (Town) o;
            return population.equals(town.population);
        }
    }


}
