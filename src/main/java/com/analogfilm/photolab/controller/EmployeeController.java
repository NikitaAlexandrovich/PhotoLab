package com.analogfilm.photolab.controller;

import com.analogfilm.photolab.models.Order;
import com.analogfilm.photolab.models.User;
import com.analogfilm.photolab.servise.OrderService;
import com.analogfilm.photolab.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EmployeeController {
    private final UserService userService;
    private final OrderService orderService;

    @Autowired
    public EmployeeController(UserService userService, OrderService orderService) {
        this.orderService = orderService;
        this.userService = userService;
    }


    @GetMapping("/employee/{name}")
    public String findAll(@PathVariable("name") String name, Model model){
        model.addAttribute("employee", userService.findByName(name));

        model.addAttribute("ordersProgress", orderService.findByEmployeeNameInProgress(name));
        model.addAttribute("ordersArchive", orderService.findByEmployeeNameArchive(name));

        return "employee/employeePage";
    }

    @GetMapping("/employee/order-done/{id}")
    public String doneOrder(@PathVariable("id") Long id, HttpServletRequest request) {
        orderService.doneOrderById(id);

        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }
}
