package com.example.tddpractice.prac1.compositepattern;

public class Transsaction implements Holdings {
    private final Long amount;

    public Transsaction(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    @Override
    public Long balance() {
        return amount;
    }
}
