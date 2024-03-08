package com.example.hw1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorAPI {
    @GetMapping("/calc/{operator}/{op1}/{op2}")
    public String calculate(@PathVariable("operator") String operation, @PathVariable("op1") Double op1, @PathVariable("op2") Double op2) {
        switch (operation) {
            case "sum":
                return String.format("%f + %f = %f", op1, op2, op1 + op2);
            case "subtract":
                return String.format("%f - %f = %f", op1, op2, op1 - op2);
            case "mult":
                return String.format("%f * %f = %f", op1, op2, op1 * op2);
            case "div":
                if (op2 == 0) {
                    return "Can not divide by zero!";
                }
                return String.format("%f / %f = %f", op1, op2, op1 / op2);
            default:
                return "Operator is not valid!";
        }
    }
}
