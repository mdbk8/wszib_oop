package com.mdbk.wszib_oop.java.week_1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex_2Test {

    @ParameterizedTest
    @MethodSource("args")
    void sums_till_thirteen_correctly(int a, int b, int c, int expectedSum) {
        assertEquals(expectedSum, Ex_2.sumTillThirteen(a, b, c));
    }

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(1, 3, 4, 8),
                Arguments.of(1, 13, 4, 1),
                Arguments.of(-10, 0, 3, -7),
                Arguments.of(4, 3, 13, 7),
                Arguments.of(13, 3, 2, 0)
        );
    }
}