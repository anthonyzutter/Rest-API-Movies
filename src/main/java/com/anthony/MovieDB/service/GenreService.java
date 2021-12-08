package com.anthony.MovieDB.service;

import com.anthony.MovieDB.model.Genre;

import java.util.Collection;

public interface GenreService {
    Collection<Genre> getAllGenres();
    Collection<Genre> getAllGenresInMovie(Long movie_id);
    Genre getGenre(Long id);
    Genre createGenre(Genre genre);
    Genre updateGenre(Long id, Genre genreRequest);
    Boolean deleteGenre(Long id);
}
