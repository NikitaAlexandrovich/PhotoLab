package com.analogfilm.photolab.servise;

import com.analogfilm.photolab.models.Film;
import com.analogfilm.photolab.models.Order;
import com.analogfilm.photolab.repository.OrderRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
@SpringBootTest
class FilmServiceTest {

    @Autowired
    private FilmService filmService;

    @MockBean
    private FilmService filmRepo;

    @Test
    void findAll() {
        ArrayList<Film> lst = new ArrayList<>();
        lst.add(new Film());
        lst.add(new Film());
        Mockito.doReturn(lst)
                .when(filmRepo)
                .findAll();
    }

    @Test
    void deleteFilm() {
        Mockito.doNothing().when(filmRepo).deleteFilm("testedFilmName");
    }

    @Test
    void findByName() {
        Mockito.doReturn(new Film())
                .when(filmRepo)
                .findByName("name");
    }

    @Test
    void saveFilm() {
        Mockito.doReturn(new Film())
                .when(filmRepo)
                .saveFilm(new Film());
    }
}