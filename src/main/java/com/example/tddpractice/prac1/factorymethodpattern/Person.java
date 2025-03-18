package com.example.tddpractice.prac1.factorymethodpattern;

public class Person {
    private final String sex;

    public Person(String sex) {
        this.sex = sex;
    }

    public static Person createMan() {
        return new Person("MAN");
    }

    public static Person createWoman() {
        return new Person("WOMAN");
    }

    public String getSex() {
        return sex;
    }
}
