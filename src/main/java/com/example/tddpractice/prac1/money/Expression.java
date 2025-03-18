package com.example.tddpractice.prac1.money;

interface Expression{

    Money reduce(Bank bank, String to);

    Expression plus(Expression dollar);
     Expression times(int count) ;
}
