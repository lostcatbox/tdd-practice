package com.example.tddpractice.prac1.templatepattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemplatePatternTest {
    // 템플릿은 자식들에게는 어떤 함수를 강요하고, 나머지는 공통화해서 상위 부모로 로직돌리는것을 의미한다.
    // 문서 추출시 ExcelFile, DocFile등이 있을텐데 이때, parser부분만 다르고 모두 같다고하면 이때 공통화한다.
    @Test
    void Excel에서_내용추출후_글자수를_센다() {
        ExcelFile excelFile = new ExcelFile();
        ExcelAbstractLetterSizeCounter excelLetterSizeCounter = new ExcelAbstractLetterSizeCounter();
        int size = excelLetterSizeCounter.count(excelFile);
        assertEquals(excelFile.getText().length(), size);
    }

    @Test
    void Docs에서_내용추출후_글자수를_센다() {
        DocsFile docsFile = new DocsFile();
        DocsAbstractLetterSizeCounter docsLetterSizeCounter = new DocsAbstractLetterSizeCounter();
        int size = docsLetterSizeCounter.count(docsFile);
        assertEquals(docsFile.getBodyText().length(), size);
    }
}
