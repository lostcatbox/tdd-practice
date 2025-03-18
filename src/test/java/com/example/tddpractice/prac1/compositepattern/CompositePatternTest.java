package com.example.tddpractice.prac1.compositepattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompositePatternTest {
    // 하나의 객체에서 다른 객체의 목록의 조합 행위처럼 보이게 하는방법
    // 복합체 패턴(Composite Pattern)은 복합 객체(Composite) 와 단일 객체(Leaf)를 동일한 컴포넌트로 취급하여, 클라이언트에게 이 둘을 구분하지 않고 동일한 인터페이스를 사용하도록 하는 구조 패턴이다.
    // 계좌(account)와 돈에 이동(transaction)을 조합하여, 고객의 전체 계좌에 대한 모든 남은 금액을 계산할수있을까?
    @Test
    void 초기화한_한개_계좌에서_100을_더하고_남은_잔액_계산하기() {
        Transsaction transsactionplus100 = new Transsaction(100L);

        Account account = new Account();
        account.addTrans(transsactionplus100);

        Assertions.assertEquals(transsactionplus100.getAmount(), account.balance());
    }

    @Test
    void 초기화한_한개_계좌에서_100을_더하고_50을_뺀후_남은_잔액_계산하기() {
        Transsaction transsactionplus100 = new Transsaction(100L);
        Transsaction transsactionminus50 = new Transsaction(-50L);

        Account account = new Account();
        account.addTrans(transsactionplus100);
        account.addTrans(transsactionminus50);

        Assertions.assertEquals(50, account.balance());
    }

    @Test
    void 여러개의_계좌에서_50L_50L에_대한_전체_잔액100L을_계산하기() {
        Transsaction transsactionplus100 = new Transsaction(100L);
        Transsaction transsactionminus50 = new Transsaction(-50L);

        Account accountA = new Account();
        accountA.addTrans(transsactionplus100);
        accountA.addTrans(transsactionminus50);
        Account accountB = new Account();
        accountB.addTrans(transsactionplus100);
        accountB.addTrans(transsactionminus50);

        accountA.addTrans(accountB);

        Assertions.assertEquals(100L, accountA.balance());
    }
}
