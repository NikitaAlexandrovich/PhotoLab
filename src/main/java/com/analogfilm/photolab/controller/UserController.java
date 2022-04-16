package com.analogfilm.photolab.controller;

import com.analogfilm.photolab.models.User;
import com.analogfilm.photolab.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user-account/{name}")
    public String userAcc(@PathVariable("name") User user, Model model) {

        model.addAttribute("user", user);
        return "user/userAccount";
    }

    @PostMapping("/user-account/update")
    public String userAccUpdate(User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        user.setUsername(currentPrincipalName);
        userService.saveUser(user);
        return "redirect:/";
    }


}
