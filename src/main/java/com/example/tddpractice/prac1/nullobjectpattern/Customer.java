package com.example.tddpractice.prac1.nullobjectpattern;

import java.time.LocalDateTime;

public class Customer {
    public static final Customer EMPTY_CUSTOMER = new Customer(

    ) {
        @Override
        public boolean afterPayTime() {
            return false;
        }

        @Override
        public void pay() {
        }

        @Override
        public boolean isPay() {
            return false;
        }

        @Override
        public LocalDateTime getPayTime() {
            return null;
        }
    };
    private boolean pay;
    private LocalDateTime payTime = LocalDateTime.now();

    public Customer() {
    }

    public Customer(boolean pay, LocalDateTime payTime) {
        this.pay = pay;
        this.payTime = payTime;
    }


    public boolean afterPayTime() {
        return payTime.isBefore(LocalDateTime.now());
    }

    public void pay() {
        pay = true;
    }

    public boolean isPay() {
        return pay;
    }

    public LocalDateTime getPayTime() {
        return payTime;
    }
}
