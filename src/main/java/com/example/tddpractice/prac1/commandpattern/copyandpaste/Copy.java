package com.example.tddpractice.prac1.commandpattern.copyandpaste;

import lombok.Getter;

@Getter
public class Copy {
    private final String text;
    private String backup;

    public Copy(ContextBody contextBody) {
        this.text = contextBody.getText();
        this.backup = contextBody.getBackup();
    }

    public void copyText() {
        backup = text;
    }

    public String getText() {
        return text;
    }

    public String getBackup() {
        return backup;
    }
}

