package com.example.tddpractice.prac1.commandpattern;

public class AlarmCommand  implements Command{
    private Alarm alarm;

    public AlarmCommand(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void execute(){
        alarm.start();
    }
}
