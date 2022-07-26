package com.parvin.learninglists.services;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.data.lists.MovieList;
import com.parvin.learninglists.data.lists.repositories.MovieListRepository;
import com.parvin.learninglists.data.works.Movie;
import com.parvin.learninglists.data.works.repositories.MovieRepository;

@Service
public final class MovieListService extends ListService<MovieListRepository, MovieRepository, MovieList, Movie> {

}
