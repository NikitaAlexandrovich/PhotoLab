package com.analogfilm.photolab.controller;

import com.analogfilm.photolab.models.User;
import com.analogfilm.photolab.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationUser(User user){
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/registrationAdmin")
    public String registrationAdmin() {
        return "registrationAdmin";
    }

    @PostMapping("/registrationAdmin")
    public String registrationAdmin(User user){
        userService.saveAdmin(user);
        return "redirect:/admin";
    }
}
