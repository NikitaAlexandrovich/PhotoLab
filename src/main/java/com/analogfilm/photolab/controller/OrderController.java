package com.analogfilm.photolab.controller;

import com.analogfilm.photolab.models.Order;
import com.analogfilm.photolab.models.Scan;
import com.analogfilm.photolab.servise.OrderService;
import com.analogfilm.photolab.servise.ScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public String findAll(Model model){
        List<Order> order = orderService.findAll();
        model.addAttribute("orders", order);
        return "order/orders";
    }
}
