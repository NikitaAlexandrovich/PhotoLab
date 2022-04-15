package com.analogfilm.photolab.controller;

import com.analogfilm.photolab.models.Film;
import com.analogfilm.photolab.models.Scan;
import com.analogfilm.photolab.servise.ScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ScanController {
    @Autowired
    private ScanService scanService;

    @GetMapping("/scans")
    public String findAll(Model model){
        model.addAttribute("scans", scanService.findAll());
        model.addAttribute("newScan", new Scan());
        return "scan/scans";
    }

    @GetMapping("/scan-delete/{name}")
    public String deleteFilm(@PathVariable("name") String name) {
        scanService.deleteScan(name);
        return "redirect:/scans";
    }

    @GetMapping("/scan-update/{name}")
    public String updateFilm(@PathVariable("name") String name, Model model) {
        model.addAttribute("scan", scanService.findByName(name));
        return "scan/update-scan";
    }

    @PostMapping("/scan-update")
    public String saveUpdate(Scan scan) {
        scanService.saveScan(scan);
        return "redirect:/scans";
    }

    @PostMapping("/scan-create")
    public String saveCreate(Scan scan) {
        scanService.saveScan(scan);
        return "redirect:/scans";
    }
}
