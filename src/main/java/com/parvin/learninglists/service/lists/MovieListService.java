package com.parvin.learninglists.service.lists;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.model.lists.MovieList;
import com.parvin.learninglists.model.works.Movie;
import com.parvin.learninglists.repository.lists.MovieListRepository;
import com.parvin.learninglists.repository.works.MovieRepository;

@Service
public final class MovieListService extends ListService<MovieListRepository, MovieRepository, MovieList, Movie> {

}
