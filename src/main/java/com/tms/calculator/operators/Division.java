package com.tms.calculator.operators;

import com.tms.calculator.exception.WrongEnterException;

public class Division implements CalcOperation {

    @Override
    public double calculate(double number1, double number2) {
        if (number2 != 0) {
            return number1 / number2;
        } else {
            throw new WrongEnterException("cannot be divided by zero");
        }
    }
}
