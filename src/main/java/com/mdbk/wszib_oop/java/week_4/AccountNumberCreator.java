package com.mdbk.wszib_oop.java.week_4;

import java.util.List;

public class AccountNumberCreator {

    private ChecksumValidator validator;

    public AccountNumberCreator(ChecksumValidator validator) {
        this.validator = validator;
    }

    public AccountNumber createAccountNumber(List<Integer> accountNumber) {
        AccountNumber.Status status = AccountNumber.Status.OK;
        if (isIllegible(accountNumber)) {
            status = AccountNumber.Status.ILL;
        } else if (hasWrongChecksum(accountNumber)) {
            status = AccountNumber.Status.ERR;
        }

        return new AccountNumber(accountNumber, status);
    }

    private boolean isIllegible(List<Integer> accountNumber) {
        return accountNumber.stream().anyMatch(it -> it == -1);
    }

    private boolean hasWrongChecksum(List<Integer> accountNumber) {
        return !validator.hasCorrectChecksum(accountNumber);
    }
}
