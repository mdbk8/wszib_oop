package com.mdbk.wszib_oop.java.week_4;

import java.util.List;

public class Scanner {

    private FileReader reader;
    private LineParser lineParser;
    private ScannedNumberConverter converter;

    public Scanner(FileReader reader, LineParser lineParser, ScannedNumberConverter converter) {
        this.reader = reader;
        this.lineParser = lineParser;
        this.converter = converter;
    }

    public List<Integer> scanFile() {
        List<ScannedNumber> scannedNumbers = lineParser.parseLines(reader.readFile());
        List<Integer> numbers = converter.convertScannedNumbersToIntegers(scannedNumbers);
        return numbers;
    }
}
