package pro.sky.calculator.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("provideDifferentNumbers")
        //Сложение
    void shouldReturnCorrectResult_WhenCorrectParams_ThenCorrectResultSum(double num1, double num2) {
        double expected = num1 + num2;

        // test
        double actual = calculatorService.getAdditionCalculator(num1, num2);

        // check
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideNullParams")
        //Сложение
    void shouldThrowException_WhenParamNullForSum(String message, Double num1, Double num2) {
        // test && check
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatorService.getAdditionCalculator(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("provideDifferentNumbers")
        //Вычитание
    void shouldReturnCorrectResult_WhenCorrectParams_ThenCorrectResultSub(double num1, double num2) {
        double expected = num1 - num2;

        // test
        double actual = calculatorService.getSubtractionCalculator(num1, num2);

        // check
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideNullParams")
        //Вычитание
    void shouldThrowException_WhenParamNullForSub(String message, Double num1, Double num2) {
        // test && check
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatorService.getSubtractionCalculator(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("provideDifferentNumbers")
        //Умножение
    void shouldReturnCorrectResult_WhenCorrectParams_ThenCorrectResultMulti(double num1, double num2) {
        double expected = num1 * num2;

        // test
        double actual = calculatorService.getMultiplicationCalculator(num1, num2);

        // check
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideNullParams")
        //Умножение
    void shouldThrowException_WhenParamNullForMulti(String message, Double num1, Double num2) {
        // test && check
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatorService.getMultiplicationCalculator(num1, num2));
    }

    @Test
        //Деление
    void shouldReturnCorrectResult_WhenCorrectParams_ThenCorrectResultDivide() {
        double num1 = 23;
        double num2 = 58;
        double expected = num1 / num2;

        // test
        double actual = calculatorService.getDivisionCalculator(num1, num2);

        // check
        assertThat(actual).isEqualTo(expected);
    }

    @Test
        //Деление
    void shouldThrowException_WhenSecondParamIsZero() {
        double num1 = 50;
        double num2 = 0;

        // test && check
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatorService.getDivisionCalculator(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("provideNullParams")
        //Деление
    void shouldThrowException_WhenParamNullForDivide(String message, Double num1, Double num2) {
        // test && check
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatorService.getDivisionCalculator(num1, num2));
    }

    private static Stream<Arguments> provideDifferentNumbers() {
        return Stream.of(Arguments.of(-123758.0, 231597.0),
                Arguments.of(0.0, 0.0),
                Arguments.of(999.999999, -999.999999),
                Arguments.of(-1.7888, -7.0),
                Arguments.of(-1246.55618934, 884.1234567));
    }

    private static Stream<Arguments> provideNullParams() {
        return Stream.of(Arguments.of("First parameter is missing", null, 2315976.0),
                Arguments.of("The second parameter is missing", 43.894, null),
                Arguments.of("Both parameters are missing", null, null),
                Arguments.of("Missing second parameter when first parameter is negative", -548.0, null),
                Arguments.of("First parameter missing when second parameter is negative", null, -78.0));
    }
}