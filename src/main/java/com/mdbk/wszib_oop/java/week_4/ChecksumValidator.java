package com.mdbk.wszib_oop.java.week_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ChecksumValidator {

    public boolean validate(List<Integer> cardNumber) {
        List<Integer> cardNumberCopy = new ArrayList<>(cardNumber);

        Collections.reverse(cardNumberCopy);

        int sum = IntStream.range(1, cardNumber.size() + 1)
                .reduce(0, (acc, current) -> (current * cardNumberCopy.get(current - 1)) + acc);

        return sum % 11 == 0;
    }
}
