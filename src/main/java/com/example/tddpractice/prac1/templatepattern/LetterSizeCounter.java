package com.example.tddpractice.prac1.templatepattern;

public abstract class LetterSizeCounter {
    abstract String parser(File file);

    int count(File file) {
        String parser = parser(file);
        return parser.length();
    }

}
