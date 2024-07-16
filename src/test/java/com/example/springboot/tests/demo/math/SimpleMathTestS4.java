package com.example.springboot.tests.demo.math;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTestS4 {

    SimpleMath math;

    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
        System.out.println("Running @BeforeEach method!");
    }


    @DisplayName("Test 6 / 3 = 2")
    @ParameterizedTest
    //@MethodSource("testDivisionInputParameters")
    @MethodSource
    void testDivision(double firstNumber, double secondNumber, double expected) {
        Double actual = math.division(firstNumber, secondNumber);

        assertEquals(expected, actual, 2D,
                () -> firstNumber + "/" + secondNumber +
                        " did not produce " + expected + "!");
    }

    //public static Stream<Arguments> testDivisionInputParameters() {
      public static  Stream<Arguments> testDivision() {
        return Stream.of(
                Arguments.of(6.2D, 2D, 3.1D),
                Arguments.of(71D, 14D, 5.07D),
                Arguments.of(18.3D, 3.1D, 5.90D)
        );
    }
}