package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();

        //Filter
        System.out.println("********* Filter **********");
        List<Person> female = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE)).toList();
        female.forEach(System.out::println);

        System.out.println("******** Sort ***********");
        //Sort
        List<Person> personList = people.stream()
                .sorted(Comparator.comparing(Person::getAge)).toList();
        personList.forEach(System.out::println);

        //All Match
        System.out.println("********* All Match **********");
        boolean allMatchPerson = people.stream()
                .allMatch(person -> person.getAge() > 5);
        System.out.println(allMatchPerson);

        //Any Match
        System.out.println("********** Any Match *********");
        boolean anyMatchPerson = people.stream()
                .anyMatch(person -> person.getAge() > 8);
        System.out.println(anyMatchPerson);

        //None Match
        System.out.println("********** None Match *********");
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Emmanuel"));
        System.out.println(noneMatch);

        //Max
        System.out.println("********* Max **********");
        Optional<Person> maxAge = people.stream()
                .max(Comparator.comparing(Person::getAge));
        System.out.println(maxAge);

        //Min
        System.out.println("********** Min *********");
        Optional<Person> minAge = people.stream()
                .min(Comparator.comparing(Person::getAge));
        System.out.println(minAge);

        //Alternatively
        System.out.println("********** Max *********");
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        //Group
        System.out.println("********* Group **********");
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        System.out.println(groupByGender);

        groupByGender.forEach((gender, people1) ->
        {
            System.out.println(gender);
            people1.forEach(System.out::println);
        });
    }


    public static List<Person> getPeople(){
        return List.of(
                new Person("Emmanuel", 20, Gender.MALE),
                new Person("Alita", 33, Gender.FEMALE),
                new Person("Grace", 57, Gender.FEMALE),
                new Person("Stephan", 14, Gender.MALE),
                new Person("Nathan", 99, Gender.MALE),
                new Person("Patricia", 7, Gender.FEMALE),
                new Person("Benedicta", 120, Gender.FEMALE)
        );
    }
}