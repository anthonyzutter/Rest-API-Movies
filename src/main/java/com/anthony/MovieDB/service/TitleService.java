package com.anthony.MovieDB.service;

import com.anthony.MovieDB.model.Title;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public interface TitleService {
    Collection<Title> getAllMovies();
    Collection<Title> getAllShows();
    Title getTitle(Long id);
    Title createTitle(Title title);
    Title updateTitle(Long id, Title titleRequest);
    Boolean deleteTitle(Long id);
    Title putGenresInTitle(Long title_id, HashMap<String, ArrayList<Long>> genres_ids);
    Boolean deleteGenresInTitle(Long title_id, HashMap<String, ArrayList<Long>> genres_ids);
}
