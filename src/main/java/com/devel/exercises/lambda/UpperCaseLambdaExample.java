package com.devel.exercises.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class Persona {

    String firstName;
    String lastName;

    Persona() {}

    Persona(String firstName, String lastName) {
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

public class UpperCaseLambdaExample {

    public static void main(String[] args) {
        List<Persona> personList = new ArrayList<>();
        personList.add(new Persona("Robert", "Lopez"));
        personList.add(new Persona("John", "Doe"));
        personList.add(new Persona("Robert", "Smith"));
        personList.add(new Persona("Mary", "Jane"));

        System.out.println("Before applying upper case");
        personList.stream().forEach(System.out::println);

        Function<Persona, Persona> toUpperCase = temp -> {
            Persona obj = new Persona();
            obj.setFirstName(temp.getFirstName().toUpperCase());
            obj.setLastName(temp.getLastName().toUpperCase());
            return obj;
        };

        List<Persona> upperCasePersons = personList.stream().map(toUpperCase).collect(Collectors.toList());

        System.out.println("\nAfter applying upper case");
        upperCasePersons.stream().forEach(System.out::println);
    }

}
