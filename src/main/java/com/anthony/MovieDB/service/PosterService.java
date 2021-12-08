package com.anthony.MovieDB.service;

import com.anthony.MovieDB.model.Poster;

import java.util.Collection;

public interface PosterService {
    Collection<Poster> getAllPosters();
    Poster getPoster(Long id);
    Poster createPoster(Long title_id, Poster poster);
    Poster updatePoster(Long title_id, Poster posterRequest);
    Boolean deletePoster(Long id);
}
