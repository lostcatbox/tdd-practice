package com.example.tddpractice.prac1.commandpattern.copyandpaste;

public class CutCommand implements ButtonCommand {
    private final ContextBody contextBody;

    public CutCommand(ContextBody contextBody) {
        this.contextBody = contextBody;
    }

    @Override
    public ContextBody execute() {
        Cut copy = new Cut(contextBody);
        copy.cutText();
        return new ContextBody(copy.getText(), copy.getBackup());
    }
}
