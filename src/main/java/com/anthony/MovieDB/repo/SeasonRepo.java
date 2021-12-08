package com.anthony.MovieDB.repo;

import com.anthony.MovieDB.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepo extends JpaRepository<Season, Long> {
}
