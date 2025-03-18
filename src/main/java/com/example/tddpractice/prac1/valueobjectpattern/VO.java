package com.example.tddpractice.prac1.valueobjectpattern;

import java.util.Objects;

public class VO {
    private final String text;

    public VO(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VO vo = (VO) o;
        return Objects.equals(getText(), vo.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getText());
    }
}
