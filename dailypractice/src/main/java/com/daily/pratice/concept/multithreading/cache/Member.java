package com.daily.pratice.concept.multithreading.cache;

/**
 * Implement high performance cache that has several readers but only one writer.
 */

final class Member {
    String name;
    double value;

    Member(String name, double value) {
        this.name = name;
        this.value = value;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    double getValue() {
        return value;
    }

    void setValue(double value) {
        this.value = value;
    }
}
