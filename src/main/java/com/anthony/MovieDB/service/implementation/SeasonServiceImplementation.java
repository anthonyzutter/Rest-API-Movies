package com.anthony.MovieDB.service.implementation;

import com.anthony.MovieDB.model.Season;
import com.anthony.MovieDB.repo.SeasonRepo;
import com.anthony.MovieDB.repo.TitleRepo;
import com.anthony.MovieDB.service.SeasonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.lang.Boolean.*;


@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class SeasonServiceImplementation implements SeasonService {
    private final SeasonRepo seasonRepo;
    private final TitleRepo titleRepo;

    @Override
    public Season createSeason(Long title_id, Season season) {
        log.info("Saving new season id: {}", season.getId());
        season.setTitle(titleRepo.findById(title_id).get());
        return seasonRepo.save(season);
    }

    @Override
    public Boolean deleteSeason(Long id) {
        log.info("Deleting season");
        seasonRepo.deleteById(id);
        return TRUE;
    }
}
