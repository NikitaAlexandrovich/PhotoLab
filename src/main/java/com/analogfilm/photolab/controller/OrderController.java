package com.analogfilm.photolab.controller;

import com.analogfilm.photolab.models.Film;
import com.analogfilm.photolab.models.Order;
import com.analogfilm.photolab.models.Scan;
import com.analogfilm.photolab.models.User;
import com.analogfilm.photolab.servise.*;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private FilmService filmService;

    @GetMapping("/orders/{name}")
    public String findAll(@PathVariable("name") User name, Model model){
        List<Order> order = orderService.findByUserName(name);
        model.addAttribute("orders", order);
        Order ord = new Order();
        ord.setNeed_develop(false);
        ord.setNeed_scan(false);
        model.addAttribute("newOrder", ord);
        model.addAttribute("employee", userService.getAllEmployee());
        model.addAttribute("films", filmService.findAll());
        return "order/orders";
    }

    @PostMapping("/order-create")
    public String createOrder(HttpServletRequest request, Order order){
        orderService.saveOrder(order);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

    @GetMapping("/order/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=UserOrders.pdf";
        response.setHeader(headerKey, headerValue);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User temp = new User();
        temp.setUsername(currentPrincipalName);

        List<Order> listFilms = orderService.findByUserName(temp);

        UserOrderExport exporter = new UserOrderExport(listFilms);
        exporter.export(response);
    }
}
