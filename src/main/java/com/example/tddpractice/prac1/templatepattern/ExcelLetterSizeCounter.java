package com.example.tddpractice.prac1.templatepattern;

public class ExcelLetterSizeCounter extends LetterSizeCounter {

    public String parser(File file) {
        ExcelFile excelFile = (ExcelFile) file;
        return excelFile.getText();
    }
}
