package com.example.tddpractice.prac1.factorymethodpattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactoryMethodPatternTest {
    //팩토리 메서드는 생성자를 통해서가 아닌 메서드를 통해서 새로운 객체의 인스턴스 반환하는 패턴
    //사실 이것보다는 템플릿 패턴과 매우 흡사하게생겼다. 최대한 간단하게만 구현했다.
    @Test
    void 남자_PERSON_메서드로_반환() {

        Person man = Person.createMan();
        Assertions.assertEquals("MAN", man.getSex());
    }

    @Test
    void 여자_PERSON_메서드로_반환() {

        Person man = Person.createWoman();
        Assertions.assertEquals("WOMAN", man.getSex());
    }
}
