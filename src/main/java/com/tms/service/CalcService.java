package com.tms.service;

import com.tms.calculator.operators.CalcOperation;
import com.tms.calculator.operators.OperatorMap;
import com.tms.dao.OperationDao;
import com.tms.entity.Operation;
import com.tms.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Component
public class CalcService {
    private final OperationDao operationDao;

    public CalcService(OperationDao operationDao) {
        this.operationDao = operationDao;
    }

    public List<Operation> getAll() {
        return operationDao.findAll();
    }

    public void calcHistory(double num1, double num2, String operation, LocalDate localDate, User user) {
        switch (operation) {
            case "sum":
                Operation sum = new Operation(num1, num2, num1 + num2, operation, localDate, user);
                operationDao.save(sum);
                break;
            case "sub":
                Operation subtraction = new Operation(num1, num2, num1 - num2, operation, localDate, user);
                operationDao.save(subtraction);
                break;
            case "mul":
                Operation multiplication = new Operation(num1, num2, num1 * num2, operation, localDate, user);
                operationDao.save(multiplication);
                break;
            case "div":
                if (num2 != 0) {
                    Operation division = new Operation(num1, num2, num1 / num2, operation, localDate, user);
                    operationDao.save(division);
                } else {
                    break;
                }
        }
    }

    public double calculation(double number1, double number2, String operation) {
        Map<String, CalcOperation> operationMap = OperatorMap.addOperatorsToMap();
        CalcOperation calcOperationMapValue = operationMap.get(operation);
        return calcOperationMapValue.calculate(number1, number2);
    }
}
