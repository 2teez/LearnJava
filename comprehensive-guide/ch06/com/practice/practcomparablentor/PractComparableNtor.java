package com.practice.practcomparablentor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class PractComparableNtor {

    public static void main(String[] args) {
        var persons = Arrays.asList(
            new Person("java", 30),
            new Person("clojure", 12)
        );
        System.out.println(persons);
        Collections.sort(persons);
        System.out.println(persons);
    }
}

class Person implements Comparable<Person> {

    public String name;
    public int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        if (this.age < person.age) return -1;
        else if (this.age == person.age) return 0;
        else return 1;
    }

    @Override
    public String toString() {
        return String.format("Person(name: %s, age:%d)", this.name, this.age);
    }
}
