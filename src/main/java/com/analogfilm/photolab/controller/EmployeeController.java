package com.analogfilm.photolab.controller;

import com.analogfilm.photolab.models.Employee;
import com.analogfilm.photolab.models.Scan;
import com.analogfilm.photolab.servise.EmployeeService;
import com.analogfilm.photolab.servise.ScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeService userService;

    @Autowired
    public EmployeeController(EmployeeService userService) {
        this.userService = userService;
    }

    @GetMapping("/employee")
    public String findAll(Model model){
        List<Employee> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/")
    public String mainScreen(Model model){
        return "photoLab";
    }

    @GetMapping("/user-create")
    public String userCreate() { return "OLDlogin"; }
}
