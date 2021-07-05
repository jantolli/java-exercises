package com.devel.exercises.lambda;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Strings {

    public static String getUniqueCharsUsingLambda(String str) {
        String result = str.chars().mapToObj((int m) -> (char) m).distinct().map(o -> o.toString()).collect(Collectors.joining(""));
        return result;
    }

    public static String getUniqueCharsUsingSet(String str) {

        char[] chars = str.toCharArray();
        Set<String> set = new HashSet<>();
        for (char aChar : chars) {
            set.add(String.valueOf(aChar));
        }
        return String.join("", set);
    }

    public static void main(String[] args) {
        String stringWithRepeatedChars = "aaaalllllmmm";
        System.out.println(getUniqueCharsUsingLambda(stringWithRepeatedChars));
        System.out.println(getUniqueCharsUsingSet(stringWithRepeatedChars));
    }

}
