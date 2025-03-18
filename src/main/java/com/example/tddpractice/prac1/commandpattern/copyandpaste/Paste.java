package com.example.tddpractice.prac1.commandpattern.copyandpaste;

import lombok.Getter;

@Getter
public class Paste {
    private String text = "";
    private String backup = "";

    public Paste() {
    }

    public Paste(ContextBody contextBody) {
        this.text = contextBody.getText();
        this.backup = contextBody.getBackup();
    }

    public void pasteText() {
        text = backup;

    }

    public String getBackup() {
        return backup;
    }

    public String getText() {
        return text;
    }
}
