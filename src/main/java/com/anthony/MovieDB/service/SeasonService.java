package com.anthony.MovieDB.service;

import com.anthony.MovieDB.model.Season;

public interface SeasonService {
    Season createSeason(Long title_id, Season season);
    Boolean deleteSeason(Long id);
}
