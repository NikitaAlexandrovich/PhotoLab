package com.analogfilm.photolab.controller;

import com.analogfilm.photolab.models.Film;
import com.analogfilm.photolab.models.Scan;
import com.analogfilm.photolab.models.Technology;
import com.analogfilm.photolab.servise.FilmService;
import com.analogfilm.photolab.servise.ScanService;
import com.analogfilm.photolab.servise.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FilmController {
    private final FilmService filmService;
    private final TechnologyService techService;
    private final ScanService scanService;

    @Autowired
    public FilmController(FilmService filmService, TechnologyService technologyService, ScanService scanService) {
        this.techService = technologyService;
        this.scanService = scanService;
        this.filmService = filmService;
    }

    @GetMapping("/films")
    public String findAllFilms(Model model) {
        model.addAttribute("films", filmService.findAll());
        List<Technology> tech = techService.findAll();
        List<Scan> scan = scanService.findAll();
        model.addAttribute("techs", tech);
        model.addAttribute("scans", scan);
        model.addAttribute("newFilm", new Film());
        return "film/films";
    }

    @GetMapping("/film-delete/{name}")
    public String deleteFilm(@PathVariable("name") String name) {
        filmService.deleteFilm(name);
        return "redirect:/films";
    }

    @GetMapping("/film-update/{name}")
    public String updateFilm(@PathVariable("name") String name, Model model) {
        model.addAttribute("film", filmService.findByName(name));
        model.addAttribute("techs", techService.findAll());
        model.addAttribute("scans", scanService.findAll());
        return "film/update-film";
    }

    @PostMapping("/film-update")
    public String saveUpdate(Film film) {
        filmService.saveFilm(film);
        return "redirect:/films";
    }

    @PostMapping("/film-create")
    public String saveCreate(Film film) {
        filmService.saveFilm(film);
        return "redirect:/films";
    }
}
