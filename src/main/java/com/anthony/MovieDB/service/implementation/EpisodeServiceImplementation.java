package com.anthony.MovieDB.service.implementation;

import com.anthony.MovieDB.model.Episode;
import com.anthony.MovieDB.repo.EpisodeRepo;
import com.anthony.MovieDB.repo.SeasonRepo;
import com.anthony.MovieDB.service.EpisodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class EpisodeServiceImplementation implements EpisodeService {
    private final EpisodeRepo episodeRepo;
    private final SeasonRepo seasonRepo;

    @Override
    public Episode createEpisode(Long season_id, Episode episode) {
        log.info("Saving new episode: {}", episode.getName());
        episode.setSeason(seasonRepo.findById(season_id).get());
        return episodeRepo.save(episode);
    }

    @Override
    public Episode updateEpisode(Long id, Episode episodeRequest) {
        log.info("Updating poster: {}", episodeRequest.getName());
        Episode episode = episodeRepo.findById(id).get();
        episode.setNumber(episodeRequest.getNumber());
        episode.setName(episodeRequest.getName());
        return episodeRepo.save(episode);
    }

    @Override
    public Boolean deleteEpisode(Long id) {
        log.info("Deleting episode");
        episodeRepo.deleteById(id);
        return TRUE;
    }
}
