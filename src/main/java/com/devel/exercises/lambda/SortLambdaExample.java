package com.devel.exercises.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {

    String firstName;
    String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "com.devel.exercises.Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

public class SortLambdaExample {

    public static void main(String[] args) {
        List<Persona> personList = new ArrayList<>();
        personList.add(new Persona("Robert", "Lopez"));
        personList.add(new Persona("John", "Doe"));
        personList.add(new Persona("Robert", "Smith"));
        personList.add(new Persona("Mary", "Jane"));

        // This works but is not easy to compare with multiple values
        // Comparator<com.devel.exercises.Person> comparator =  (com.devel.exercises.Person o1, com.devel.exercises.Person o2) -> o1.firstName.compareTo(o2.firstName);

        Comparator<Persona> comparator = Comparator.comparing((Persona o) -> o.getFirstName()).thenComparing((Persona o) -> o.getLastName());

        System.out.println("Before Sorting");
        personList.stream().forEach(System.out::println);

        Collections.sort(personList, comparator);
        System.out.println("\nAfter Sorting");

        personList.stream().forEach(System.out::println);

    }

}
