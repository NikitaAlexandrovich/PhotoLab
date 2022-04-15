package com.analogfilm.photolab.servise;

import com.analogfilm.photolab.models.Film;
import com.analogfilm.photolab.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> findAll() { return filmRepository.findAll(); }
    public void deleteFilm(String name) {
        filmRepository.deleteById(name);
    }
    public Film findByName(String name) { return filmRepository.getById(name); }
    public Film saveFilm(Film film) { return filmRepository.save(film); }
}