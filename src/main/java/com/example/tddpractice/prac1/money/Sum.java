package com.example.tddpractice.prac1.money;

public class Sum implements Expression{
    private Expression augend;
    private Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to) {
        return new Money(this.augend.reduce(bank, to).amount
                + this.addend.reduce(bank, to).amount,to);
    }

    @Override
    public Expression times(int multiplier) {
        augend = augend.times(multiplier);
        addend = addend.times(multiplier);
        return this;
    }

    @Override
    public Expression plus(Expression dollar) {
        return new Sum(this, dollar);
    }
}
