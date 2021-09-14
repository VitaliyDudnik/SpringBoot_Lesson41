package com.tms.calculator.operators;

import java.util.HashMap;
import java.util.Map;

public class OperatorMap {

    public static Map<String, CalcOperation> addOperatorsToMap() {
        Map<String, CalcOperation> calcOperationMap = new HashMap<>();
        calcOperationMap.put("sum", new Sum());
        calcOperationMap.put("mul", new Multiplication());
        calcOperationMap.put("div", new Division());
        calcOperationMap.put("sub", new Subtraction());
        return new HashMap<>(calcOperationMap);
    }
}
