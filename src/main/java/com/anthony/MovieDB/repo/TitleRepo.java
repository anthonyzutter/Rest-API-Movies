package com.anthony.MovieDB.repo;

import com.anthony.MovieDB.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TitleRepo extends JpaRepository<Title, Long> {
    Title findByName(String name);
    @Query
    List<Title> findAllByisMovie(Boolean isMovie);
}
