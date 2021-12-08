package com.anthony.MovieDB.service.implementation;

import com.anthony.MovieDB.model.Genre;
import com.anthony.MovieDB.repo.GenreRepo;
import com.anthony.MovieDB.service.GenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class GenreServiceImplementation implements GenreService {
    private final GenreRepo genreRepo;

    @Override
    public Collection<Genre> getAllGenres() {
        log.info("Fetching all genres");
        return genreRepo.findAll();
    }

    @Override
    public Collection<Genre> getAllGenresInMovie(Long movie_id) {
        log.info("Fetching all genres");
        return genreRepo.findAllByTitles_Id(movie_id);
    }

    @Override
    public Genre getGenre(Long id) {
        log.info("Fetching genre by id: {}", id);
        return genreRepo.findById(id).get();
    }

    @Override
    public Genre createGenre(Genre genre) {
        log.info("Saving new poster: {}", genre.getName());
        return genreRepo.save(genre);
    }

    @Override
    public Genre updateGenre(Long id, Genre genreRequest) {
        log.info("Saving new poster: {}", genreRequest.getName());
        Genre genre = genreRepo.findById(id).get();
        genre.setName(genreRequest.getName());
        return genreRepo.save(genre);
    }


    @Override
    public Boolean deleteGenre(Long id) {
        log.info("Deleting genre by id: {}", id);
        genreRepo.deleteById(id);
        return TRUE;
    }
}
