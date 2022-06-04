package com.example.spring.app.service;

import com.example.spring.app.model.Film;

import java.util.List;

public interface FilmService {
    List<Film> allFilms(int page);
    void add(Film film);
    void delete(Film film);
    void edit(Film film);
    Film getById(int id);
    int filmsCount();
}
