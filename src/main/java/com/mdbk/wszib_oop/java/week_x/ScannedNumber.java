package com.mdbk.wszib_oop.java.week_x;

public class ScannedNumber {

    private Boolean top;
    private final Boolean bottom;
    private final Boolean left1;
    private final Boolean left2;
    private final Boolean right1;
    private final Boolean right2;

    public ScannedNumber(Boolean top,
                         Boolean bottom,
                         Boolean left1,
                         Boolean left2,
                         Boolean right1,
                         Boolean right2) {
        this.top = top;
        this.bottom = bottom;
        this.left1 = left1;
        this.left2 = left2;
        this.right1 = right1;
        this.right2 = right2;
    }
}
