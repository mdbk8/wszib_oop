package com.mdbk.wszib_oop.java.week_4;

import java.util.Arrays;
import java.util.List;

public class Scanner {

    private FileReader reader;
    private AccountNumberParser accountNumberParser;
    private ScannedNumberConverter converter;

    public Scanner(FileReader reader, AccountNumberParser accountNumberParser, ScannedNumberConverter converter) {
        this.reader = reader;
        this.accountNumberParser = accountNumberParser;
        this.converter = converter;
    }

    // TODO write it in functional style
    public List<Integer> scanFile() {
        List<String> lines = reader.readFile();

        for (int index = 0; index < lines.size(); index++) {
            if (index % 2 != 0 && index != 0) continue;

            List<String> list = Arrays.asList(lines.get(index), lines.get(index + 1), lines.get(index + 2));

            List<ScannedNumber> scannedNumbers = accountNumberParser.parseAccountNumber(list);
            List<Integer> cardNumbers = converter.convertScannedNumbersToIntegers(scannedNumbers);

            index += 2;
        }

        return null;
    }
}
