package com.mdbk.wszib_oop.java.week_4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scanner {

    private FileReader reader;
    private AccountNumberWriter writer;
    private AccountNumberParser accountNumberParser;
    private ScannedNumberConverter converter;
    // TODO find better name
    private AccountNumberCreator creator;

    public Scanner(FileReader reader,
                   AccountNumberParser accountNumberParser,
                   ScannedNumberConverter converter,
                   AccountNumberCreator creator,
                   AccountNumberWriter writer) {
        this.reader = reader;
        this.accountNumberParser = accountNumberParser;
        this.converter = converter;
        this.creator = creator;
        this.writer = writer;
    }

    // TODO write it in functional style
    public void scanFile(File file) {
        List<String> lines = reader.readFile(file);
        List<AccountNumber> accountNumbers = new ArrayList<>();

        for (int index = 0; index < lines.size(); index++) {
            if (index % 2 != 0 && index != 0) continue;

            List<String> list = Arrays.asList(lines.get(index), lines.get(index + 1), lines.get(index + 2));

            List<ScannedNumber> scannedNumbers = accountNumberParser.parseAccountNumber(list);
            List<Integer> accountNumber = converter.convertScannedNumbersToIntegers(scannedNumbers);

            AccountNumber number = creator.createAccountNumber(accountNumber);
            accountNumbers.add(number);

            index += 2;
        }

        try {
            writer.write(accountNumbers);
        } catch (IOException e) {
            // TODO think about improving this useless code
            e.printStackTrace();
        }
    }
}
