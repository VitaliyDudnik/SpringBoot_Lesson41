package com.tms.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({RuntimeException.class})
    public String handleRunTimeException(RuntimeException runtimeException, Model model) {
        model.addAttribute("exMessage", runtimeException.getMessage());
        return "home";
    }
}
