package com.mdbk.wszib_oop.java.week_4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class AccountNumberWriter {

    private File file;

    public AccountNumberWriter(File file) {
        this.file = file;
    }

    public void write(List<AccountNumber> number) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(file));

        for (AccountNumber accountNumber : number) {
            switch (accountNumber.getStatus()) {
                case OK:
                    printWriter.println(numberToString(accountNumber.getNumber()));
                    break;
                case ERR:
                case ILL:
                    printWriter.printf("%s %s", numberToString(accountNumber.getNumber()), accountNumber.getStatus());
                    printWriter.println();
                    break;
            }
        }

        printWriter.close();
    }

    private String numberToString(List<Integer> number) {
        return number.stream().map(num -> num == -1 ? "?" : String.valueOf(num)).collect(Collectors.joining());
    }
}
