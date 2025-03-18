package com.example.tddpractice.prac1.commandpattern;

import lombok.Getter;

@Getter
public class Lamp {
    private boolean on;

    public void turnOn(){
        on = true;
    }
}
