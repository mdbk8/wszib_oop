package com.mdbk.wszib_oop.java.week_4;

import java.util.List;
import java.util.Objects;

public class AccountNumber {

    private List<Integer> number;
    private Status status;

    public AccountNumber(List<Integer> number, Status status) {
        this.number = number;
        this.status = status;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public Status getStatus() {
        return status;
    }

    public enum Status {
        OK, ERR, ILL
    }

    @Override
    public String toString() {
        return "AccountNumber{" +
                "number=" + number +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountNumber that = (AccountNumber) o;
        return Objects.equals(number, that.number) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, status);
    }
}
