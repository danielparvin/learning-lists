package com.parvin.learninglists.repositories.lists;

import org.springframework.data.repository.CrudRepository;

import com.parvin.learninglists.data.lists.MovieList;

public interface MovieListRepository extends CrudRepository<MovieList, Long> {

}
