package com.tms.calculator.operators;

public class Sum implements CalcOperation {
    @Override
    public double calculate(double number1, double number2) {
        return number1 + number2;
    }
}
