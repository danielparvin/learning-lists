package com.parvin.learninglists.data.lists.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.lists.MovieList;

public interface MovieListRepository extends PagingAndSortingRepository<MovieList, Long> {

}
