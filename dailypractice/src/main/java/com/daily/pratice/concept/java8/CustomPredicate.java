package com.daily.pratice.concept.java8;

@FunctionalInterface
public interface CustomPredicate<T> {
     boolean test( T t);
    default CustomPredicate<T> and( CustomPredicate<T> other) {
        return t -> test(t) && other.test(t);
    }
}

