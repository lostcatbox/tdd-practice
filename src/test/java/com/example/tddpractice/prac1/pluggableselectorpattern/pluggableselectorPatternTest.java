package com.example.tddpractice.prac1.pluggableselectorpattern;

import org.junit.jupiter.api.Test;

public class pluggableselectorPatternTest {
    // 플러거블 셀렉터 패턴
    // 인스턴스별로 동적으로 메서드를 선택하여 동작하여야한다면? 어떻게해야할까?
    // 상위 클래스, 하위클래스를 만들어 함수가 추가될때마다 선택하는건 너무 무거운 방법이다.
    // 반대로, switch문을 통해서 작성하는것 역시 매 함수명이 다르기때문에 함수명마다 작성하는것은 무거운 방법이다.
    // 그래서 java 리플랙션을 이용하여 다음과같이 동적으로 할당하여 메서드를 실행 할수있도록한다.

    @Test
    void 플러거블_셀렉터_패턴_테스트() {
        JUnit junit = new JUnit();

        junit.addTest(UnderTest.class);

        junit.runTest();
    }
}
