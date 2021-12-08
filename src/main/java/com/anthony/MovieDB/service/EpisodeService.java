package com.anthony.MovieDB.service;

import com.anthony.MovieDB.model.Episode;

public interface EpisodeService {
    Episode createEpisode(Long season_id, Episode episode);
    Episode updateEpisode(Long id, Episode episodeRequest);
    Boolean deleteEpisode(Long id);
}
