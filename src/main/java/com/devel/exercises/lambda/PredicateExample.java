package com.devel.exercises.lambda;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

    public static Predicate<Integer> greaterThanOne() {
        return (x) -> x > 1;
    }

    public static Predicate<Integer> lessThanFive() {
        return (x) -> x < 5;
    }

    public static void main(String[] args) {

        // Lambda Predicate FunctionalInterface using Filter - Example 1
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List filteredList1 = list1.stream().filter((x) -> x > 1 && x < 5).collect(Collectors.toList());
        System.out.println(filteredList1);

        // Lambda Predicate FunctionalInterface using Filter - Example 2
        Integer[] list2 = new Integer[] {1, 2, 3, 4, 5};
        // Note how we assign the lambda expression to a FunctionalInterface
        Predicate<Integer> predicate1 = (x) -> x > 1;
        Predicate<Integer> predicate2 = (x) -> x < 5;
        List filteredList2 = Arrays.asList(list2).stream().filter(predicate1.and(predicate2)).collect(Collectors.toList());
        System.out.println(filteredList2);

        // Lambda Predicate FunctionalInterface assigning predicate to a method - Example 3
        Integer[] list3 = new Integer[] {1, 2, 3, 4, 5};
        // Note how we assign the lambda expression to a FunctionalInterface
        List filteredList3 = Arrays.asList(list2)
                .stream()
                .filter(greaterThanOne()
                        .and(lessThanFive()))
                .collect(Collectors.toList());
        System.out.println(filteredList2);

        // The Predicate FunctionalInterface includes a default and() operator.
        // We can us that instead together with a list of Predicates - Example 4
        List<Predicate<Integer>> allPredicates = new ArrayList<Predicate<Integer>>();
        allPredicates.add(x -> x > 1);
        allPredicates.add(x -> x < 5);
        Integer[] list4 = new Integer[] {1, 2, 3, 4, 5};
        // Note how we assign the lambda expression to a FunctionalInterface
        List filteredList4 = Arrays.asList(list2)
                .stream()
                .filter(allPredicates
                        .stream()
                        // reduce() is a reduction operation. This is parallelizable
                        .reduce(x -> true, Predicate::and))
                .collect(Collectors.toList());
        System.out.println(filteredList2);

    }
}
