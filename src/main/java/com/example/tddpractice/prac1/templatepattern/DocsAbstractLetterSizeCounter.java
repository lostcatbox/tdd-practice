package com.example.tddpractice.prac1.templatepattern;

public class DocsAbstractLetterSizeCounter extends AbstractLetterSizeCounter {
    public String parser(File file) {
        DocsFile docsFile = (DocsFile) file;
        return docsFile.getBodyText();
    }
}
