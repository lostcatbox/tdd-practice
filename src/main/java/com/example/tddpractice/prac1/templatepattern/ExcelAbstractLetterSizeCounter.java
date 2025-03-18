package com.example.tddpractice.prac1.templatepattern;

public class ExcelAbstractLetterSizeCounter extends AbstractLetterSizeCounter {

    public String parser(File file) {
        ExcelFile excelFile = (ExcelFile) file;
        return excelFile.getText();
    }
}
