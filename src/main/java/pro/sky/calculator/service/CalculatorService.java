package pro.sky.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double getAdditionCalculator(Double num1, Double num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Один из параметров отсутствует.");
        }
        return num1 + num2;
    }

    public double getSubtractionCalculator(Double num1, Double num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Один из параметров отсутствует.");
        }
        return num1 - num2;
    }

    public double getMultiplicationCalculator(Double num1, Double num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Один из параметров отсутствует.");
        }
        return num1 * num2;
    }

    public double getDivisionCalculator(Double num1, Double num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Один из параметров отсутствует.");
        } if (num2 == 0) {
            throw new IllegalArgumentException("Делить на 0 нельзя.");
        }
        return num1 / num2;
    }
}
