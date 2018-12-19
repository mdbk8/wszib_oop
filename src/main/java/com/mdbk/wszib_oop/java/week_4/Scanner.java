package com.mdbk.wszib_oop.java.week_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<String> scanFile() {
        List<String> lines = reader.readFile();
        List<String> numbers = new ArrayList<>();

        for (int index = 0; index < lines.size(); index++) {
            if (index % 2 != 0 && index != 0) continue;

            List<String> list = Arrays.asList(lines.get(index), lines.get(index + 1), lines.get(index + 2));

            List<ScannedNumber> scannedNumbers = accountNumberParser.parseAccountNumber(list);
            List<Integer> cardNumbers = converter.convertScannedNumbersToIntegers(scannedNumbers);

            String cardNumber = cardNumbers.stream().map(number -> number + "").collect(Collectors.joining());
            numbers.add(cardNumber);

            index += 2;
        }

        return numbers;
    }
}
