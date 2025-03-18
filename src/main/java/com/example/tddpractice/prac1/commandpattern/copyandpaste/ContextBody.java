package com.example.tddpractice.prac1.commandpattern.copyandpaste;

import lombok.Getter;

@Getter
public class ContextBody {
    private String text;
    private String backup;

    public ContextBody(String text, String backup) {
        this.text = text;
        this.backup = backup;
    }

    public String getText() {
        return text;
    }

    public String getBackup() {
        return backup;
    }
}
