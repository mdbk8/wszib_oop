package com.mdbk.wszib_oop.java.week_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Scanner {

    private FileReader reader;
    private AccountNumberParser accountNumberParser;
    private ScannedNumberConverter converter;
    private ChecksumValidator validator;

    public Scanner(FileReader reader,
                   AccountNumberParser accountNumberParser,
                   ScannedNumberConverter converter,
                   ChecksumValidator validator) {
        this.reader = reader;
        this.accountNumberParser = accountNumberParser;
        this.converter = converter;
        this.validator = validator;
    }

    // TODO write it in functional style
    public List<String> scanFile() {
        List<String> lines = reader.readFile();
        List<String> numbers = new ArrayList<>();

        for (int index = 0; index < lines.size(); index++) {
            if (index % 2 != 0 && index != 0) continue;

            List<String> list = Arrays.asList(lines.get(index), lines.get(index + 1), lines.get(index + 2));

            List<ScannedNumber> scannedNumbers = accountNumberParser.parseAccountNumber(list);
            List<Integer> cardNumber = converter.convertScannedNumbersToIntegers(scannedNumbers);

            if (validator.validate(cardNumber)) {
                String stringCardNum = cardNumber.stream().map(String::valueOf).collect(Collectors.joining());
                numbers.add(stringCardNum);
            }

            index += 2;
        }

        return numbers;
    }
}
