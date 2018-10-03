package com.mdbk.wszib_oop.week_1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Ex_1Test {

    @ParameterizedTest
    @MethodSource("teenArguments")
    void isTeen_returns_true(int firstNum, int secondNum) {
        assertTrue(Ex_1.isTeen(firstNum, secondNum));
    }

    @ParameterizedTest
    @MethodSource("nonTeenArguments")
    void isTeen_returns_false(int firstNum, int secondNum) {
        assertFalse(Ex_1.isTeen(firstNum, secondNum));
    }

    private static Stream<Arguments> teenArguments() {
        return Stream.of(
                Arguments.of(12, 13),
                Arguments.of(20, 13),
                Arguments.of(19, 20),
                Arguments.of(10, 15),
                Arguments.of(16, 9),
                Arguments.of(16, -9)
        );
    }

    private static Stream<Arguments> nonTeenArguments() {
        return Stream.of(
                Arguments.of(13, 19),
                Arguments.of(10, 10),
                Arguments.of(13, 13),
                Arguments.of(19, 19),
                Arguments.of(16, 17),
                Arguments.of(-1, -10)
        );
    }
}