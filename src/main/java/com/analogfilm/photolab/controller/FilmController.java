package com.analogfilm.photolab.controller;

import com.analogfilm.photolab.servise.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilmController {
    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) { this.filmService = filmService; }

    @GetMapping("/films")
    public String findAllFilms(Model model) {
        model.addAttribute("films", filmService.findAll());
        return "film/films";
    }
}
