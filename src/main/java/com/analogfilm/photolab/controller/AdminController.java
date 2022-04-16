package com.analogfilm.photolab.controller;

import com.analogfilm.photolab.models.Order;
import com.analogfilm.photolab.models.User;
import com.analogfilm.photolab.servise.OrderService;
import com.analogfilm.photolab.servise.UserOrderExport;
import com.analogfilm.photolab.servise.UserService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class AdminController {
    private final UserService userService;
    private final OrderService orderService;

    @Autowired
    public AdminController(UserService userService, OrderService orderService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("orders", orderService.findAll());
        model.addAttribute("admins", userService.getAllAdmins());
        model.addAttribute("clients", userService.getAllClient());
        model.addAttribute("employees", userService.getAllEmployee());
        return "admin/adminPage";
    }

    @GetMapping("/admin/orders/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=AllLabOrders.pdf";
        response.setHeader(headerKey, headerValue);
        List<Order> listFilms = orderService.findAll();
        UserOrderExport exporter = new UserOrderExport(listFilms);
        exporter.export(response);
    }

    @GetMapping("/admin/admin-update/{name}")
    public String updateAdminForm(@PathVariable("name") String name, Model model) {
        model.addAttribute("admin", userService.findByName(name));
        return "admin/updateAdmin";
    }

    @PostMapping("/admin/admin-update")
    public String updateAdmin(User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        user.setUsername(currentPrincipalName);
        userService.saveAdmin(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/admin-delete/{name}")
    public String deleteAdmin(@PathVariable("name") String name) {
        userService.deleteById(name);
        return "redirect:/admin";
    }

    @GetMapping("/admin/client-delete/{name}")
    public String deleteClient(@PathVariable("name") String name) {
        userService.deleteById(name);
        return "redirect:/admin";
    }

    @GetMapping("/admin/employee-update/{name}")
    public String updateEmployeeForm(@PathVariable("name") String name, Model model) {
        model.addAttribute("admin", userService.findByName(name));
        return "admin/updateEmployee";
    }

    @PostMapping("/admin/employee-update")
    public String updateEmployee(User user){
        userService.saveEmployee(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/employee-delete/{name}")
    public String deleteEmployee(@PathVariable("name") String name) {
        userService.deleteById(name);
        return "redirect:/admin";
    }

    @GetMapping("/admin/registrationEmployee")
    public String registrationEmployee() {
        return "admin/registrationEmployee";
    }

    @PostMapping("/admin/registrationEmployee")
    public String registrationEmployee(User user){
        userService.saveEmployee(user);
        return "redirect:/admin";
    }
}
