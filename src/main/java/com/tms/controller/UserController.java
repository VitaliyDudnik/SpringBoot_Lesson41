package com.tms.controller;

import com.tms.Constants;
import com.tms.entity.User;
import com.tms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@SessionAttributes("user")
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String get() {
        return "home";
    }

    @GetMapping("/reg")
    public String regGet() {
        return "registration";
    }

    @PostMapping("/reg")
    public String regPost(@Valid User user, BindingResult result, SessionStatus session, Model model) {
        if (result.hasErrors()) {
            for (FieldError fieldError : result.getFieldErrors()) {
                model.addAttribute("errorRegistration", fieldError.getDefaultMessage());
            }
            session.setComplete();
            return "registration";
        }
       boolean existsUsername = userService.existsUserByUsername(user.getUsername());
       boolean existsPassword = userService.existsUserByPassword(user.getPassword());
        if (!existsUsername & !existsPassword){
            model.addAttribute("user", user);
            userService.save(user);
         }else {
            model.addAttribute("wrongPasswordOrUsername", Constants.ATTRIBUTE_EXISTS_USERNAME_PASS);
            return "registration";
        }
        return "home";
    }

    @GetMapping("/auth")
    public String authorizationGet() {
        return "authorization";
    }

    @PostMapping("/auth")
    public String authorizationPost(@Valid User user, BindingResult bindingResult, Model model, SessionStatus session) {

        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                model.addAttribute("errorAuthorization", fieldError.getDefaultMessage());
            }
            session.setComplete();
            return "authorization";
        }

        boolean existsPassword = userService.existsUserByPassword(user.getPassword());
        if (existsPassword) {
            User user1 = userService.getUserByPassword(user.getPassword());
            if (user1.getUsername().equals(user.getUsername())) {
                model.addAttribute("user", userService.getUserByPassword(user.getPassword()));
            }
        } else {
            model.addAttribute("ExistsUsernamePassword", Constants.ATTRIBUTE_EXISTS_USERNAME_PASS);
            session.setComplete();
            return "authorization";
        }
        return "home";
    }

    @PostMapping("/logout")
    public String logoutPost(SessionStatus session){
        session.setComplete();
        return "home";
    }

    @GetMapping("/notRegistered")
    public String notRegPost(){
        return "notRegistered";
    }
}


