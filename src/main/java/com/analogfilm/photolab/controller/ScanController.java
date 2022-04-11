package com.analogfilm.photolab.controller;

import com.analogfilm.photolab.models.Employee;
import com.analogfilm.photolab.models.Scan;
import com.analogfilm.photolab.servise.EmployeeService;
import com.analogfilm.photolab.servise.ScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ScanController {
    @Autowired
    private ScanService scanService;


    @GetMapping("/scans")
    public String findAll(Model model){
        List<Scan> scan = scanService.findAll();
        model.addAttribute("scans", scan);
        return "scan/scans";
    }

}
