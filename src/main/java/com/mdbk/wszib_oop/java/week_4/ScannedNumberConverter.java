package com.mdbk.wszib_oop.java.week_4;

import java.util.List;
import java.util.stream.Collectors;

public class ScannedNumberConverter {

    public List<Integer> convertScannedNumbersToIntegers(List<ScannedNumber> scannedNumbers) {
        return scannedNumbers
                .stream()
                .map(this::toInteger)
                .collect(Collectors.toList());
    }

    // TODO refactor this ugly code to enum or something more scalable
    private Integer toInteger(ScannedNumber number) {
        if (number.equals(ScannedNumber.ZERO)) return 0;
        else if (number.equals(ScannedNumber.ONE)) return 1;
        else if (number.equals(ScannedNumber.TWO)) return 2;
        else if (number.equals(ScannedNumber.THREE)) return 3;
        else if (number.equals(ScannedNumber.FOUR)) return 4;
        else if (number.equals(ScannedNumber.FIVE)) return 5;
        else if (number.equals(ScannedNumber.SIX)) return 6;
        else if (number.equals(ScannedNumber.SEVEN)) return 7;
        else if (number.equals(ScannedNumber.EIGHT)) return 8;
        else if (number.equals(ScannedNumber.NINE)) return 9;

        throw new IllegalArgumentException();
    }
}
