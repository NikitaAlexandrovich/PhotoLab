package com.analogfilm.photolab.repository;

import com.analogfilm.photolab.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, String> {
}
