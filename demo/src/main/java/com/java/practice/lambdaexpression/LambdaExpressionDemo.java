package com.java.practice.lambdaexpression;

import com.java.practice.functionalinterface.MathOperations;
import com.java.practice.functionalinterface.Person;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExpressionDemo {
    public static void main(String[] args) {
        MathOperations addition = (a, b) -> System.out.println(a + b);
        addition.operation(5, 10);

        MathOperations multiplication = (a, b) -> System.out.println(a * b);
        multiplication.operation(5, 10);

        addition.defaultMethod();
        multiplication.defaultMethod();
        MathOperations.staticMethod();

        System.out.println();

        // Predicate
        Predicate<Person> olderThan23 = p -> p.getAge() >= 23;
        for (Person p : Person.createList()) {
            if (olderThan23.test(p)) {
                System.out.println(p);
            }
        }

        System.out.println();

        List<Person> persons = Person.createList();
        // Consumer
        Consumer<Person> printPerson = Person::printPerson;
        for (Person p : persons) {
            printPerson.accept(p);
        }

        System.out.println();

        // Function
        Function<Person, String> getNameFromPerson = Person::getName;
        for (Person p : persons) {
            System.out.println(getNameFromPerson.apply(p));
        }

        System.out.println();

        // Supplier
        Supplier<Person> personSupplier = () -> new Person("Anthony", 21, "anthony@x.com");
        System.out.println(personSupplier.get());
    }
}