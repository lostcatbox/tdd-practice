package com.example.tddpractice.prac1.commandpattern;

import lombok.Getter;

@Getter
public class Alarm{
    private boolean on;

    public void start(){
        on = true;
    }
}