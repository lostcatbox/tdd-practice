package com.example.tddpractice.prac1.commandpattern.copyandpaste;

import lombok.Getter;

@Getter
public class Cut {
    private String text;
    private String backup;

    public Cut() {
    }

    public Cut(ContextBody contextBody) {
        this.text = contextBody.getText();
        this.backup = contextBody.getBackup();
    }

    public void cutText() {
        backup = text;
        text = "";
    }

    public String getText() {
        return text;
    }

    public String getBackup() {
        return backup;
    }
}
