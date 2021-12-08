package com.anthony.MovieDB.repo;

import com.anthony.MovieDB.model.Poster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosterRepo extends JpaRepository<Poster, Long> {
}
