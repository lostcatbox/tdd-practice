package com.example.tddpractice.prac1.imposterpattern;

import com.example.tddpractice.prac1.nullobjectpattern.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ImposterPatternTest {
    //임포스터 패턴은 그냥 다형성을 이용하여 언제든 교체가능한 것을 보는 것이 필요하다는 느낌이다.
    // 널 객체와 일반 객체 또한 서로 다형성으로 정확히 대칭되므로 임포스터 패턴이다
    // 이런 객체를 찾아낸다면, 리팩토링 대상이다.
    @Test
    void 고객이_정상적인_객체일경우_비즈니스로직에서는_일반적인응답을한다() {
        Customer customer = new Customer(false, LocalDateTime.now());
        if (customer.afterPayTime()) {
            customer.pay();
        }
        Assertions.assertNotNull(customer);
        Assertions.assertTrue(customer.isPay());
    }

    @Test
    void 고객이_널객체일경우_비즈니스로직에서는_NPE없이_일반적인응답을한다() {
        Customer customer = Customer.EMPTY_CUSTOMER;
        if (customer.afterPayTime()) {
            customer.pay();
        }
        Assertions.assertNotNull(customer);
        Assertions.assertFalse(customer.isPay());
    }

}
