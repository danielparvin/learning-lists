package com.parvin.learninglists.service.works;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.model.works.Movie;
import com.parvin.learninglists.repository.works.MovieRepository;

@Service
public class MovieService extends WorkService<MovieRepository, Movie> {

}
