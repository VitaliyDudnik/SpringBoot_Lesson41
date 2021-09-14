package com.tms.controller;

import com.tms.calculator.exception.WrongEnterException;
import com.tms.entity.Operation;
import com.tms.entity.User;
import com.tms.service.CalcService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@SessionAttributes("user")
@RequestMapping("/calc")
public class CalcController {
    private final CalcService calcService;

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping("/calculate")
    public String calcGet() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calcPost(double num1, double num2, String operation, Model model) {

        User user = (User) model.getAttribute("user");
        try {
            if (user != null) {
                calcService.calcHistory(num1, num2, operation, LocalDate.now(), user);
            }
            double result = calcService.calculation(num1, num2, operation);
            model.addAttribute("result", "Result: " + result);
        } catch (WrongEnterException e) {
            model.addAttribute("wrongEnter", "you cannot divide by zero");
            return "calculator";
        } catch (Exception ex) {
            model.addAttribute("error", "try again");
            return "calculator";
        }
        return "calculator";
    }

    @GetMapping("/history")
    public String historyGet(Model model, SessionStatus session) {
        User user = (User) model.getAttribute("user");
        try {
            if (user != null) {
                List<Operation> operationList = calcService.getAll();
                List<Operation> historyList = operationList.stream()
                        .filter(o -> o.getUser().getUsername().equals(user.getUsername()))
                        .collect(Collectors.toList());
                model.addAttribute("calcHistory", historyList);
            }
        } catch (NullPointerException e) {
            model.addAttribute("exceptionNull", "Something went wrong, please log in again.");
            session.setComplete();
            return "authorization";
        } catch (Exception ex) {
            model.addAttribute("exceptionInHistoryPost", "Oops! Little problem, try again");
            return "calculator";
        }
        return "calcHistory";
    }
}
