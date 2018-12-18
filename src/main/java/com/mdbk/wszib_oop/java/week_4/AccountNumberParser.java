package com.mdbk.wszib_oop.java.week_4;

import java.util.ArrayList;
import java.util.List;

public class AccountNumberParser {

    // gets only three lines - one row of numbers
    public List<ScannedNumber> parseAccountNumber(List<String> lines) {
        String firstLine = lines.get(0);
        String secondLine = lines.get(1);
        String thirdLine = lines.get(2);
        List<ScannedNumber> scannedNumbers = new ArrayList<>(9);

        int numOfChars = firstLine.toCharArray().length;

        // TODO move to separate methods
        // TODO ignore whitespaces
        for (int offset = 0; offset < numOfChars; offset++) {
            boolean top = (firstLine.charAt(offset + 1) + "").equals("_");

            boolean left1 = (secondLine.charAt(offset) + "").equals("|");
            boolean middle = (secondLine.charAt(offset + 1) + "").equals("_");
            boolean right1 = (secondLine.charAt(offset + 2) + "").equals("|");

            boolean left2 = (thirdLine.charAt(offset) + "").equals("|");
            boolean bottom = (thirdLine.charAt(offset + 1) + "").equals("_");
            boolean right2 = (thirdLine.charAt(offset + 2) + "").equals("|");

            scannedNumbers.add(new ScannedNumber(top, bottom, middle, left1, left2, right1, right2));
            offset += 2;
        }

        return scannedNumbers;
    }
}
