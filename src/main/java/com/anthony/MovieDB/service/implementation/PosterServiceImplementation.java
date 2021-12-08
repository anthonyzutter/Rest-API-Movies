package com.anthony.MovieDB.service.implementation;

import com.anthony.MovieDB.model.Poster;
import com.anthony.MovieDB.repo.TitleRepo;
import com.anthony.MovieDB.repo.PosterRepo;
import com.anthony.MovieDB.service.PosterService;
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
public class PosterServiceImplementation implements PosterService {
    private final PosterRepo posterRepo;
    private final TitleRepo titleRepo;


    @Override
    public Collection<Poster> getAllPosters() {
        log.info("Fetching all posters");
        return posterRepo.findAll();
    }

    @Override
    public Poster getPoster(Long id) {
        log.info("Fetching poster by id: {}", id);
        return posterRepo.findById(id).get();
    }

    @Override
    public Poster createPoster(Long title_id, Poster poster) {
        log.info("Saving new poster: {}", poster.getUrl());
        poster.setTitle(titleRepo.findById(title_id).get());
        return posterRepo.save(poster);
    }

    @Override
    public Poster updatePoster(Long id, Poster posterRequest) {
        log.info("Updating poster: {}", posterRequest.getUrl());
        Poster poster = posterRepo.findById(id).get();
        poster.setUrl(posterRequest.getUrl());
        return posterRepo.save(poster);
    }

    @Override
    public Boolean deletePoster(Long id) {
        log.info("Deleting poster by id: {}", id);
        posterRepo.deleteById(id);
        return TRUE;
    }
}
