package com.example.tddpractice.prac1.compositepattern;


import java.util.ArrayList;
import java.util.List;

public class Account implements Holdings {
    private final List<Holdings> transsactions = new ArrayList<>();

    public Account() {
    }

    public void addTrans(Holdings transsaction) {
        transsactions.add(transsaction);
    }

    public Long balance() {
        Long sum = 0L;

        for (Holdings transsaction : transsactions) {
            sum += transsaction.balance();
        }
        return sum;
    }
}
