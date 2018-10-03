package com.mdbk.wszib_oop.week_1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Ex_3Test {

    @ParameterizedTest
    @MethodSource("args")
    void finds_one_two_three_sequence_correctly(int[] values, boolean hasSequence) {
        assertEquals(hasSequence, Ex_3.hasOneTwoThreeSequence(values));
    }

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 4}, true),
                Arguments.of(new int[]{1, 2, 4, 9, 1, 2, 3}, true),
                Arguments.of(new int[]{1, 2, 4, 9, 1, 2, 2}, false),
                Arguments.of(new int[]{3, 2, 1, 9, 1, 2, 2}, false),
                Arguments.of(new int[]{3, 2, 1, 1, 2, 3, 1}, true)
        );
    }
}