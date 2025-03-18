package com.example.tddpractice.prac1.commandpattern.copyandpaste;

public class Button {
    private final ButtonCommand buttonCommand;

    public Button(ButtonCommand buttonCommand) {
        this.buttonCommand = buttonCommand;
    }

    public ContextBody click() {
        return buttonCommand.execute();
    }
}
