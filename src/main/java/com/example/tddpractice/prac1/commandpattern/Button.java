package com.example.tddpractice.prac1.commandpattern;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Button {
    private List<Command> commands = new ArrayList<>();

    public Button() {
    }

    public void addCommand(Command command){
        commands.add(command);
    }

    public void execute() {
        for (Command command : commands){
            command.execute();
        }
    }
}
