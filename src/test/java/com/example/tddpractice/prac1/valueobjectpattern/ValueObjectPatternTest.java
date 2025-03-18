package com.example.tddpractice.prac1.valueobjectpattern;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ValueObjectPatternTest {
    //값 객체는 반드시 equals와 hashcode 를 재정의해야한다.
    // 값 객체는 한번 생성되면 절대로 값을 바꿀수없다.
    // 값 객체는 ID가없으므로 어디에서 만들든 항상 새로운 객체를 반환하는것이 기존 인스턴스와 같을수있다.
    // 새로 생성하여도 값 객체는 equals, hashcode를 통해 등등성을 지키는지 확인해보자

    @Test
    void 일반적인객체는_메모리값이_다르면_다른객체다_새로_생성시_속성값이_모두_같아도_다른객체다() {
        NonVO 첫번째객체 = new NonVO("동일한 텍스트");
        NonVO 두번째객체 = new NonVO("동일한 텍스트");
        HashSet<NonVO> objectHashSet = new HashSet<>();
        objectHashSet.add(첫번째객체);
        objectHashSet.add(두번째객체);

        assertNotEquals(첫번째객체, 두번째객체);
        assertEquals(첫번째객체.getText(), 두번째객체.getText());
        assertEquals(2, objectHashSet.size());

    }

    @Test
    void 값_객체는_ID_값을_갖으며_새로_생성시_값이_모두_같으면_동일한_객체다() {
        VO 첫번째객체 = new VO("동일한 텍스트");
        VO 두번째객체 = new VO("동일한 텍스트");

        HashSet<VO> objectHashSet = new HashSet<>();
        objectHashSet.add(첫번째객체);
        objectHashSet.add(두번째객체);
        assertEquals(첫번째객체, 두번째객체);
        assertEquals(첫번째객체.getText(), 두번째객체.getText());
        assertEquals(1, objectHashSet.size());
    }
}
