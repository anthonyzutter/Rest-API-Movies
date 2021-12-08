package com.anthony.MovieDB.repo;

import com.anthony.MovieDB.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepo extends JpaRepository<Episode, Long> {
}
