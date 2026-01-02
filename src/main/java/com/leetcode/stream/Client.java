package com.leetcode.stream;

import java.util.List;

public class Client {

    public static void main(String[] args) {
        var persons = List.of(
                new Person("aaa", 11),
                new Person("bbb", 222)
                );

        System.out.println("#########");
        persons.stream().forEach(System.out::println);
        System.out.println("#########");


        List<Person>  minorsPersons = persons.stream()
                .filter(p -> p.age < 18)
                .toList();
        System.out.println(minorsPersons);

    }

    record Person(String name, int age) {
    }
}
