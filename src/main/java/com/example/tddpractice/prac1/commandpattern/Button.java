package com.example.tddpractice.prac1.commandpattern;

import lombok.Getter;

@Getter
public class Button {
    private Alarm alarm;
    private Lamp lamp;

    public Button(Alarm alarm, Lamp lamp) {
        this.alarm = alarm;
        this.lamp = lamp;
    }

    private boolean on;

    public void turnOn() {
        on = true;
        alarm.turnOn();
        lamp.turnOn();
    }
}
