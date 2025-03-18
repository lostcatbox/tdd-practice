package com.example.tddpractice.prac1.commandpattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandPatternTest {
    // 커멘드 패턴이란?
    // 호출자와 수신자를 행동을 분리하는 패턴
    // 목적 -> button을 누르면, 램프가 켜지고, 알람도 켜지는 프로그램제작
    // 할일
    // 램프 켜지는것 확인
    // 알림 켜지는것 확인
    // button 누르면, 램프, 알림 켜지는것 확인
    // 이제 리팩토링 해보자 -> 현재는 Button turnOn()메서드에서 직접 lamp, alarm의 turnOn()을 호출할경우, Button의 turnOn메서드도 같이 수정되어야함
    @Test
    public void 램프가_켜짐(){
        Lamp lamp = new Lamp();
        lamp.turnOn();
        assertTrue(lamp.isOn());
    }
    @Test
    public void 알림가_켜짐(){
        Alarm alarm = new Alarm();
        alarm.start();
        assertTrue(alarm.isOn());
    }

    @Test
    public void 버튼_켜면_램프와_알림_모두_켜짐(){
        Alarm alarm = new Alarm();
        Lamp lamp = new Lamp();
        Command alarmButton = new AlarmCommand(alarm);
        Command lampButton = new LampCommand(lamp);
        Button button = new Button();
        button.addCommand(alarmButton);
        button.addCommand(lampButton);
        button.execute();

        assertTrue(alarm.isOn());
        assertTrue(lamp.isOn());
    }




}