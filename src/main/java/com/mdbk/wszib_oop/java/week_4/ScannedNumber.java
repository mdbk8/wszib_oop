package com.mdbk.wszib_oop.java.week_4;

import java.util.Objects;

public class ScannedNumber {

    private Boolean top;
    private final Boolean bottom;
    private Boolean middle;
    private final Boolean left1;
    private final Boolean left2;
    private final Boolean right1;
    private final Boolean right2;

    public static ScannedNumber ZERO = new ScannedNumber(true, true, false, true, true, true, true);
    public static ScannedNumber ONE = new ScannedNumber(false, false, false, false, false, true, true);
    public static ScannedNumber TWO = new ScannedNumber(true, true, true, false, true, true, false);
    public static ScannedNumber THREE = new ScannedNumber(true, true, true, false, false, true, true);
    public static ScannedNumber FOUR = new ScannedNumber(false, false, true, true, false, true, true);
    public static ScannedNumber FIVE = new ScannedNumber(true, true, true, true, false, false, true);
    public static ScannedNumber SIX = new ScannedNumber(true, true, true, true, true, false, true);
    public static ScannedNumber SEVEN = new ScannedNumber(true, false, false, false, false, true, true);
    public static ScannedNumber EIGHT = new ScannedNumber(true, true, true, true, true, true, true);
    public static ScannedNumber NINE = new ScannedNumber(true, true, true, true, false, true, true);

    public ScannedNumber(Boolean top,
                         Boolean bottom,
                         Boolean middle,
                         Boolean left1,
                         Boolean left2,
                         Boolean right1,
                         Boolean right2) {
        this.top = top;
        this.bottom = bottom;
        this.middle = middle;
        this.left1 = left1;
        this.left2 = left2;
        this.right1 = right1;
        this.right2 = right2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScannedNumber that = (ScannedNumber) o;
        return Objects.equals(top, that.top) &&
                Objects.equals(bottom, that.bottom) &&
                Objects.equals(middle, that.middle) &&
                Objects.equals(left1, that.left1) &&
                Objects.equals(left2, that.left2) &&
                Objects.equals(right1, that.right1) &&
                Objects.equals(right2, that.right2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(top, bottom, middle, left1, left2, right1, right2);
    }
}
