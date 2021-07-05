package com.devel.exercises.lambda;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Write a function in Java that takes a string as its input and prints the letters in that string in reverse order,
 * with the letters in the odd-numbered positions in upper-case and the letters in even-numbered positions in lower case.
 */
public class StringChars {

    public static String reverseSortUsingAtomicIntegerIndex(String str) {
        AtomicInteger index = new AtomicInteger(0);
        Comparator<Character> comparator = (Character o1, Character o2) -> o2.compareTo(o1);  // note reverse order
        // Can be replaced with the easier one
        // Comparator<Character> comparator = Comparator.reverseOrder();
        List<String> reversed = str.chars()
                .mapToObj((int o) -> (char) o)
                // Can be also done using ".sorted(Comparator.reverseOrder())"
                .sorted((Character o1, Character o2) -> o2.compareTo(o1))
                .filter(n -> index.incrementAndGet() <= str.length())
                .map((Character x) -> index.intValue() % 2 != 0 ? x.toString().toLowerCase() : x.toString().toUpperCase())
                .collect(Collectors.toList());

        String result = reversed.stream().collect(Collectors.joining(""));
        System.out.println(result);
        return result;
    }

    public static String reverseSortUsingIntStream(String str) {

        String reverseSorted = str.chars()
                .mapToObj((int o) -> (char) o)
                .sorted(Comparator.reverseOrder())
                .map((Character x) -> x.toString())
                .collect(Collectors.joining(""));

        String result = IntStream
                .range(0, reverseSorted.length())
                .filter((int i) -> i <= reverseSorted.length())
                .mapToObj((int i) -> i % 2 == 0 ? String.valueOf(reverseSorted.charAt(i)).toLowerCase() : String.valueOf(reverseSorted.charAt(i)).toUpperCase())
                .collect(Collectors.joining(""));

        System.out.println(result);
        return result;
    }

    public static String reverseSortUsingJava7(String str) {
        char[] reversed = applyTransformation(str.toCharArray());
        System.out.println(reversed);
        return reversed.toString();
    }

    public static char[] applyTransformation(char[] letters) {
        char[] reversed = new char[letters.length];

        // First sort by natural order
        Arrays.sort(letters);
        // Then let's traverse reversed and assign to a new array
        for (int i = 0; i < letters.length; i++) {
            String value = null;
            // While we traverse let's apply the transformation
            if (i % 2 == 0) {
                value = String.valueOf(letters[letters.length - 1 - i]).toLowerCase();
            } else {
                value = String.valueOf(letters[letters.length - 1 - i]).toUpperCase();
            }
            reversed[i] = value.charAt(0);
        }
        return reversed;
    }

    public static void main(String[] args) {
        String str = "123456789abcdEFGHijkl";
        StringChars.reverseSortUsingAtomicIntegerIndex(str);
        StringChars.reverseSortUsingIntStream(str);
        StringChars.reverseSortUsingJava7(str);
    }

}
