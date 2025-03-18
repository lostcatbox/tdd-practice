package com.example.tddpractice.prac1.commandpattern.copyandpaste;

public class CopyCommand implements ButtonCommand {
    private final ContextBody contextBody;

    public CopyCommand(ContextBody contextBody) {
        this.contextBody = contextBody;
    }

    @Override
    public ContextBody execute() {
        Copy copy = new Copy(contextBody);
        copy.copyText();
        return new ContextBody(copy.getText(), copy.getBackup());
    }
}
