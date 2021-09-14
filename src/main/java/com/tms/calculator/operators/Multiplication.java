package com.tms.calculator.operators;

public class Multiplication implements CalcOperation {
    @Override
    public double calculate(double number1, double number2) {
        return number1 * number2;
    }
}
