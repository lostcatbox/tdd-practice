package com.example.tddpractice.prac1.commandpattern.copyandpaste;

public class PasteCommand implements ButtonCommand {
    private final ContextBody contextBody;

    public PasteCommand(ContextBody contextBody) {
        this.contextBody = contextBody;
    }

    @Override
    public ContextBody execute() {
        Paste paste = new Paste(contextBody);
        paste.pasteText();
        return new ContextBody(paste.getText(), paste.getBackup());
    }
}
