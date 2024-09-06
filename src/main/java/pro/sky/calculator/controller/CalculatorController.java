package pro.sky.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator.service.CalculatorService;

@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String getWelcomeCalculator() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String getAdditionCalculator(@RequestParam(value = "num1", required = false) Double num1,
                                        @RequestParam(value = "num2", required = false) Double num2) {

        Double result = calculatorService.getAdditionCalculator(num1, num2);
        return num1 + " + " + num2 + " = " + String.format(" %.3f ", result);
    }

    @GetMapping("/minus")
    public String getSubtractionCalculator(@RequestParam(value = "num1", required = false) Double num1,
                                           @RequestParam(value = "num2", required = false) Double num2) {
        Double result = calculatorService.getSubtractionCalculator(num1, num2);
        return num1 + " + " + num2 + " = " + String.format(" %.3f ", result);
    }

    @GetMapping("/multiply")
    public String getMultiplicationCalculator(@RequestParam(value = "num1", required = false) Double num1,
                                              @RequestParam(value = "num2", required = false) Double num2) {
        Double result = calculatorService.getMultiplicationCalculator(num1, num2);
        return num1 + " * " + num2 + " = " + String.format(" %.3f ", result);
    }

    @GetMapping("/divide")
    public String getDivisionCalculator(@RequestParam(value = "num1", required = false) Double num1,
                                        @RequestParam(value = "num2", required = false) Double num2) {
        if (num1 == null || num2 == null) {
            return "Один из параметров отсутствует.";
        }
        if (num2 == 0) {
            return "<span style=\"color: #F00;\">ВНИМАНИЕ, КОД КРАСНЫЙ!!!</span> Делить на 0 нельзя, одумайся.";
        }
        Double result = calculatorService.getDivisionCalculator(num1, num2);
        return num1 + " / " + num2 + " = " + String.format(" %.3f ", result);
    }
}
