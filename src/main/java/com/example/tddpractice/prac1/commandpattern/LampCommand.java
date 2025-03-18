package com.example.tddpractice.prac1.commandpattern;

public class LampCommand implements Command{
    private Lamp lamp;

    public LampCommand(Lamp lamp) {
        this.lamp = lamp;
    }
    @Override
    public void execute() {
        lamp.turnOn();
    }
}
