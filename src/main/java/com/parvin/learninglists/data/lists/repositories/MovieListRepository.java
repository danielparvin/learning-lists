package com.parvin.learninglists.data.lists.repositories;

import org.springframework.data.repository.CrudRepository;

import com.parvin.learninglists.data.lists.MovieList;

public interface MovieListRepository extends CrudRepository<MovieList, Long> {

}
