package com.example.tddpractice.prac1.money;

import com.example.tddpractice.prac1.money.Bank;
import com.example.tddpractice.prac1.money.Expression;
import com.example.tddpractice.prac1.money.Money;
import com.example.tddpractice.prac1.money.Sum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


// TDD-> 원하는 테스트 작성후 실패(레드) -> 성공시키기(그린) -> 중복제거 및 구조변경(리팩토링)
// 1. 테스트를 작성한다(마음속에 있는 원하는 오퍼레이션이 코드로 어떤식으로 나타나길 원하는지 생각하고, 이야기를 쓴다. 원하는 인터페이스를 개발하라,올바른 답을 얻기위한 필요한 이야기의 모든 요소를 포함시켜라)
// 2. 실행 가능하게 만단다.(2가지 방법이있다. 1. 가짜 구현 = 상수를 반환하게 만든다. 추후에는 변수로 치환한다.실행가능하게 만들기만하면된다. 2. 진짜구현 = 간단한 수정사항 구현가능하다면 진행
// 3. 올바르게 만든다. 이제 시스템이 동작(테스트통과) 하므로 직전에 저질렀던 죄악을 수습하자. 좁고 올곧은 소프트웨어 정의의 길로 되돌아와서 중복을 제거하고 초록색으로 만들자
// 4. 리팩토링 한다. 결함을 찾거나 요구사항 늘어날시 할일 및 테스트 추가 작성 다음 할일 선택후 1번 반복

public class MoneyTest {
    // 기존 = 화폐단위 하나에 대해서만 각 주식수*주당가격을 합계 프로그램이 개발되어있었다.
    // 개발 목적 = 다양한 화폐로, 구성된 주식수*주당가격을 최종 합산하는 프로그램을 개발해야한다.
    // 예시 = 10dollar*1 + 10CHF*1 = 15dollar (dollar/CHF= 0.5)
    // 할일
    // 다른 화폐단위 합 지원 -> 10dollar + 10CHF = 15dollar (dollar/CHF= 0.5)
    // 곱하기 지원 -> 10dollar*2 = 20dollar

    //곱하기 지원이 쉬워보이니까 먼저 지원해보자
    //Money는 10
    // money원하는 특성은 5
    //현재 만드는 것의 특성은 ID값이 없는 값 객체의 특성을 알게 됨 -> 이는 equals()와 hashCode()재정의가 필요함을 알게됨
    @Test
    public void test1Multipl(){
        //팩토리 메서드 도입이유는, 테스트에서 하위클래스에서 상위클래스 의존성을 줄일수있으므로
        Money dollar10 = Money.dollar(10);
        Expression dollar20 =dollar10.times(2);
        assertEquals(Money.dollar(20), dollar20);
        Expression dollar30 =dollar10.times(3);
        assertEquals(Money.dollar(30), dollar30);
    }
    //현재 만드는 것의 특성은 ID값이 없는 값 객체의 특성을 알게 됨 -> 이는 equals()와 hashCode()재정의가 필요함을 알게됨
    // Money 상위 클래스로 개발후에 Franc와 Dollar를 비교하는 코드가 필요하다는것을 알고 계속 할일추가 및 테스트작성
    // Money 상위 클래스로 equals를 통합했는데, 중간에  assertFalse(Money.dollar(10).equals(Money.franc(10))); 해당부분실패. 즉, Money equals에는 getClass보다 이제 currency 동일성 비교가 필요해보임
    @Test
    public void test1equality(){
        assertTrue(Money.dollar(10).equals(Money.dollar(10)));
        assertFalse(Money.dollar(10).equals(Money.dollar(11)));
        assertTrue(Money.franc(10).equals(Money.franc(10)));
        assertFalse(Money.franc(10).equals(Money.franc(11)));
        assertFalse(Money.dollar(10).equals(Money.franc(10)));
        assertFalse(Money.franc(10).equals(Money.dollar(10)));
    }

    //이제 곱하기 기능은 지원이 가능해졌다. 그럼 "다른 화폐단위 합 지원" 해보자
    //먼저 화폐단위를 추가해보자 Franc추가
    //중복 코드가 매우 많아졌고, Money라는 상위 클래스로 모으기로함
    @Test
    public void test1FrancMultipl(){
        Money franc10 = Money.franc(10);
        Expression franc20 =franc10.times(2);
        assertEquals(Money.franc(20), franc20);
        Expression franc30 =franc10.times(3);
        assertEquals(Money.franc(30), franc30);
    }

    //통화 개념을 넣기위해 currency 등장. 어떻게 테스트 하고 활용하기를 원하는가>
    //assertEquals("USD", Money.dollar(1).currency); 을 원한다.
    @Test
    public void testCurrency(){
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

//    @Test
//    public void testDifferentClassEquality(){
//        //해당부분이 성공해야한다. currency에대한 변수값이 중요함으로
//        assertTrue(new Money(10, "CHF").equals(new Franc(10, "CHF")));
//    }

    //합산에 대한테스트 작성
    //10dollar + 10CHF = 15dollar (dollar/CHF= 0.5)
    //화폐단위를 치면, 나중에 값을 반환해주는것이필요할거같은데? plus 함수만들어서 같은거면 가능 아니면 valid
    //다른 환율은 어떻게 계산하지?
    //계산하는 동작을 객체로 만들어 저장한다면 어떨까? 계산을 Expression으로 메타포로 표현하면 어떨까?
    @Test
    public void testSum(){
//        Money dollar  = Money.dollar(10).plus(Money.dollar(10));
//        assertTrue(dollar.equals(Money.dollar(20)));
//        Money franc  = Money.franc(10).plus(Money.franc(10));
//        assertTrue(franc.equals(Money.franc(20)));
        Money five  = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Expression reduced = bank.reduce(sum, "USD");
        assertTrue(reduced.equals(Money.dollar(10)) );
    }
    @Test
    public void testplusReturnSum(){
        Money five  = Money.dollar(5);
        Expression expression = five.plus(five);
        Sum sum =(Sum) expression;
        Bank bank = new Bank();
        Expression reduced = bank.reduce(sum, "USD");
        assertTrue(reduced.equals(Money.dollar(10)) );
    }
    @Test
    public void testReduceSum(){
        Sum sum = new Sum(Money.dollar(10), Money.dollar(10));
        Bank bank = new Bank();
        Expression reduced = bank.reduce(sum, "USD");
        assertTrue(reduced.equals(Money.dollar(20)) );
    }
    @Test
    public void testReduceDollar(){
        Bank bank = new Bank();
        Expression reduced = bank.reduce(Money.dollar(1), "USD");
        assertTrue(reduced.equals(Money.dollar(1)) );
    }
    @Test
    public void testBankDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression reduced = bank.reduce(Money.franc(2), "USD");
        assertTrue(reduced.equals(Money.dollar(1)) );
    }

    @Test
    public void testIdentityRates(){
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    // 10dollar*1 + 10CHF*1 = 15dollar (USD/CHF= 2)
    @Test
    public void testBankDifferentCurrencySum(){
        Expression franc = Money.franc(10);
        Expression dollar = Money.dollar(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression plus = franc.plus(dollar);
        Expression reduced = bank.reduce(plus, "USD");
        assertTrue(reduced.equals(Money.dollar(15)) );
    }

    @Test
    public void testMoneySum(){
        Expression franc = Money.franc(10);
        Expression dollar = Money.dollar(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(franc, dollar).plus(dollar);
        Expression reduced = bank.reduce(sum, "USD");
        assertTrue(reduced.equals(Money.dollar(25)) );
    }
    @Test
    public void testExpressionTimes(){
        Expression franc = Money.franc(10);
        Expression dollar = Money.dollar(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(franc, dollar);
        Expression times = sum.times(2);
        Expression reduced = bank.reduce(times, "USD");
        assertTrue(reduced.equals(Money.dollar(30)) );
    }

}
