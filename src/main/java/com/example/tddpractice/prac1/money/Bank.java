package com.example.tddpractice.prac1.money;

import java.util.Hashtable;
import java.util.Objects;

class Bank {

    private Hashtable rates = new Hashtable();
    // 해당 reduce부분은 원래 SUM객체의 public 변수를 직접 접근하여 계산하고 있었으며,
    // 이를 sum객체에 reduce 메서드를 만들어 외부에서는 해당 변수 접근을 안하며,  private으로 변경하였다.
    // 이후, 현재 reduce 를 만약 Expression 인터페이스에 적용한다면, 공통된 reduce를 갖음에 따라 인스턴스 검사가 필요없어진다.


    public Expression reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    public void addRate(String source, String to, int rate) {
        rates.put(new Pair(source, to), rate);
    }

    public int rate(String source, String to) {
        if(source.equals(to)){ return 1;}
        return (int)rates.get(new Pair(source, to));

    }

    private class Pair {
        private String from;
        private String to;

        Pair(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return Objects.equals(from, pair.from) && Objects.equals(to, pair.to);
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }
}