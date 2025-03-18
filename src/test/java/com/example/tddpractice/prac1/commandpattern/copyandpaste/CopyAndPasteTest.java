package com.example.tddpractice.prac1.commandpattern.copyandpaste;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CopyAndPasteTest {
    //프로그램목적: copy, cut, paste 되는 프로그램을 작성한다. 유저입장에서는 Button을 눌렀을때, 각자 copy, cut, paste 기능을 수행한다.
    //Copy, Cut, Paste객체를 만들었지만, 클라이언트입장에서는 각자 사용해야함. 이를 Command로 공통화시킨다면? 기능차이를 몰라도 사용자가 command만 호출해서 사용할수있음
    // Command를 통해 공통화 시켰고, button은 아무것도 모르고 Command를 호출시킬뿐이다.

    private Fixture fixture;

    @BeforeEach
    void doSetUp() {
        fixture = new Fixture();
    }

    @Test
    void copy는_현재_텍스트내용이_복사된다() {
        Copy copy = new Copy(fixture.contextBody);
        copy.copyText();
        String text = copy.getText();
        assertEquals(fixture.now, text);
    }

    @Test
    void cut는_현재_텍스트내용이_잘라내기된다() {
        Cut cut = new Cut(fixture.contextBody);
        cut.cutText();
        String text = cut.getText();
        String backup = cut.getBackup();
        assertEquals("", text);
        assertEquals(fixture.now, backup);
    }

    @Test
    void paste는_현재_텍스트내용이_붙여넣기된다() {
        Paste paste = new Paste(fixture.contextBody);
        paste.pasteText();
        String text = paste.getText();
        assertEquals(fixture.backup, text);
    }

    @Test
    void copyButton_click시_내용이_복사된다() {
        CopyCommand copyCommand = new CopyCommand(fixture.contextBody);
        Button copyButton = new Button(copyCommand);
        ContextBody clickedBody = copyButton.click();
        assertEquals(fixture.now, clickedBody.getBackup());
    }

    @Test
    void cutButton_click시_내용이_잘라내기된다() {
        CutCommand cutCommand = new CutCommand(fixture.contextBody);
        Button cutButton = new Button(cutCommand);
        ContextBody clickedBody = cutButton.click();
        assertEquals("", clickedBody.getText());
        assertEquals(fixture.now, clickedBody.getBackup());

    }

    @Test
    void pasteButton_click시_내용이_붙여넣기된다() {
        PasteCommand pasteCommand = new PasteCommand(fixture.contextBody);
        Button pasteButton = new Button(pasteCommand);
        ContextBody clickedBody = pasteButton.click();
        assertEquals(fixture.backup, clickedBody.getText());
    }

    private class Fixture {
        String now = "지금본문내용";
        String backup = "백업내용";
        ContextBody contextBody = new ContextBody(now, backup);
    }
}
