package com.parvin.learninglists.repository.lists;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.model.lists.MovieList;

@Repository
public interface MovieListRepository extends PagingAndSortingRepository<MovieList, Long> {

}
