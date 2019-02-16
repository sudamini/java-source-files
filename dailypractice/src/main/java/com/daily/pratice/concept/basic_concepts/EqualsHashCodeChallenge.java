package com.daily.pratice.concept.basic_concepts;

import java.util.HashSet;
import java.util.Set;

/**
 * Rules for object comparison
 * When a hashcode() comparison returns false, the equals() method must also return false.
 * If the hashcode is different, then the objects are definitely not equal.
 *
 * Object comparison with hashcode()
 * When the hashcode comparison returns true, The equals() method should return true or false.
 * When the hashcode comparison returns false, The equals() method should return false.
 * When the equals() method returns true, it means that the objects are equal in all values and attributes.
 * In this case,  the hashcode comparison must be true as well.
 *
 * Object comparison with equals()
 * When the equals() method returns true, hashcode() method should return true
 * When the equals() method returns false, hashcode() method should return true or false
 *
 */

final class EqualsHashCodeChallenge {

        public static void main(String... doYourBest) {
            System.out.println(new Simpson("Bart").equals(new Simpson("Bart")));
            Simpson overriddenHomer = new Simpson("Homer") {
                public int hashCode() {
                    return (43 + 777) + 1;
                }
            };

            System.out.println(new Simpson("Homer").equals(overriddenHomer));

            Set<Simpson> set = new HashSet<>();
            set.add(new Simpson("Homer"));
            set.add(new Simpson("Marge"));
            set.add(new Simpson("Homer"));
            set.add(overriddenHomer);

            System.out.println(set.size());
        }

        static class Simpson {
            String name;

            Simpson(String name) {
                this.name = name;
            }

            @Override
            public boolean equals(Object obj) {
                Simpson otherSimpson = (Simpson) obj;
                return this.name.equals(otherSimpson.name) &&
                        this.hashCode() == otherSimpson.hashCode();
            }

            @Override
            public int hashCode() {
                return (43 + 777);
            }
        }

    }
