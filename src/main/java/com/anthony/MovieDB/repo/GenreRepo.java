package com.anthony.MovieDB.repo;

import com.anthony.MovieDB.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenreRepo extends JpaRepository<Genre, Long> {
    Genre findByName(String name);
    List<Genre> findAllByTitles_Id(Long movie_id);
}
