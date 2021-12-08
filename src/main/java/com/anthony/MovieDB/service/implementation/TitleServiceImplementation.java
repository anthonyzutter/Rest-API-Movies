package com.anthony.MovieDB.service.implementation;

import com.anthony.MovieDB.model.Genre;
import com.anthony.MovieDB.model.Title;
import com.anthony.MovieDB.repo.GenreRepo;
import com.anthony.MovieDB.repo.TitleRepo;
import com.anthony.MovieDB.service.TitleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

import static java.lang.Boolean.*;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class TitleServiceImplementation implements TitleService {
    private final TitleRepo titleRepo;
    private final GenreRepo genreRepo;

    @Override
    public Title createTitle(Title title) {
        log.info("Saving new movie: {}", title.getName());
        // Date added
        return titleRepo.save(title);
    }

    @Override
    public Collection<Title> getAllMovies() {
        log.info("Fetching all movies");
        return titleRepo.findAllByisMovie(true);
    }

    @Override
    public Collection<Title> getAllShows() {
        log.info("Fetching all movies");
        return titleRepo.findAllByisMovie(false);
    }

    @Override
    public Title getTitle(Long id) {
        log.info("Fetching title by id: {}", id);
        return titleRepo.findById(id).get();
    }

    @Override
    public Title updateTitle(Long id, Title titleRequest) {
        log.info("Updating title: {}", titleRequest.getName());
        Title title = titleRepo.findById(id).get();
        title.setName(titleRequest.getName());
        title.setDescription(titleRequest.getDescription());
        title.setReleaseDate(titleRequest.getReleaseDate());
        return titleRepo.save(title);
    }

    @Override
    public Boolean deleteTitle(Long id) {
        log.info("Deleting title by id: {}", id);
        Title title = titleRepo.findById(id).get();
        List<Genre> genres = new ArrayList<>(title.getGenres());
        for (Genre genre : genres) {
            genre.deleteTitle(title);
        }
//        for (int n = 0; n < genres.size(); n++) {
//            genres.get(n).deleteMovie(movie);
//        }
        titleRepo.deleteById(id);
        return TRUE;
    }

    @Override
    public Title putGenresInTitle(Long title_id, HashMap<String, ArrayList<Long>> genres_ids) {
        log.info("Putting genres in movie");
        Title title = titleRepo.findById(title_id).get();

        ArrayList<Long> genresIds = genres_ids.get("genres_ids");
        for (long genreId : genresIds) {
            if (!genreRepo.existsById(genreId)) {
                throw new NullPointerException("Genre " + genreId + " Not found");
            }
            title.addGenre(genreRepo.findById(genreId).get());
        }
        return titleRepo.save(title);
    }

    @Override
    public Boolean deleteGenresInTitle(Long title_id, HashMap<String, ArrayList<Long>> genres_ids) {
        log.info("Deleting genres in title");
        Title title = titleRepo.findById(title_id).get();

        ArrayList<Long> genresIds = genres_ids.get("genres_ids");
        for (long genreId : genresIds) {
            if (!genreRepo.existsById(genreId)) {
                throw new NullPointerException("Genre " + genreId + " Not found");
            }
            title.deleteGenre(genreRepo.findById(genreId).get());
        }
        return TRUE;
    }
}
