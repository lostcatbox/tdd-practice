package com.example.tddpractice.prac1.nullobjectpattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class NullObjectPatternTest {
    //NullObject는  NPE와 null체크를 줄여준다. if(object!=null){throw NPE} 를 없애는것이다.
    // 널 객체는 기존의 객체의 모든 함수를 정상동작(false, donothing)등을 하며, 기존객체와 다를빠없는 객체를 제공한다.

    @Test
    void 고객이_정상적인_객체일경우_비즈니스로직에서는_일반적인응답을한다() {
        Customer customer = new Customer(false, LocalDateTime.now());
        if (customer != null && customer.afterPayTime()) {
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
