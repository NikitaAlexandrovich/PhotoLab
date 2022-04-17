package com.analogfilm.photolab.controller;

import com.analogfilm.photolab.models.Scan;
import com.analogfilm.photolab.models.Technology;
import com.analogfilm.photolab.servise.ScanExport;
import com.analogfilm.photolab.servise.ScanService;
import com.analogfilm.photolab.servise.TechnologyExport;
import com.analogfilm.photolab.servise.TechnologyService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class TechnologyController {
    @Autowired
    private TechnologyService technologyServiceService;

    @GetMapping("/technology")
    public String findAll(Model model){
        model.addAttribute("techs", technologyServiceService.findAll());
        model.addAttribute("newTech", new Technology());
        return "technology/technology";
    }

    @GetMapping("/technology-delete/{name}")
    public String deleteFilm(@PathVariable("name") String name) {
        technologyServiceService.deleteTech(name);
        return "redirect:/technology";
    }

    @GetMapping("/technology-update/{name}")
    public String updateFilm(@PathVariable("name") String name, Model model) {
        model.addAttribute("tech", technologyServiceService.findByName(name));
        return "technology/update-technology";
    }

    @PostMapping("/technology-update")
    public String saveUpdate(Technology tech) {
        technologyServiceService.saveTech(tech);
        return "redirect:/technology";
    }

    @PostMapping("/technology-create")
    public String saveCreate(Technology tech) {
        technologyServiceService.saveTech(tech);
        return "redirect:/technology";
    }

    @GetMapping("/technology/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Technology.pdf";
        response.setHeader(headerKey, headerValue);
        List<Technology> listScans = technologyServiceService.findAll();
        TechnologyExport exporter = new TechnologyExport(listScans);
        exporter.export(response);
    }

}
