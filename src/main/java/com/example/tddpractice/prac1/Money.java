package com.example.tddpractice.prac1;

class Money implements Expression
{
    protected int amount;
    protected String currency;
    public String currency(){
        return currency;
    }
    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
@Override
    public Expression times(int count) {
        return new Money(count*amount, currency);
    }

    public static Money dollar(int i) {
        return new Money(i, "USD");
    }
    public static Money franc(int i) {
        return new Money(i, "CHF");
    }

    @Override
    public Expression plus(Expression dollar) {
        return new Sum(this,dollar);
    }

    public int getAmount() {
        return amount;
    }
    public boolean equals(Object o) {

        Money dollar = (Money) o;
        //답은 맞았는데, 클래스가 다르다. -> 중요한건 클래스가 아니라 애초에 통화다.
        return amount == dollar.getAmount() && dollar.currency.equals(currency);
    }

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }
    @Override
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(this.currency, to);
        return new Money(amount/rate, to);
    }
}
