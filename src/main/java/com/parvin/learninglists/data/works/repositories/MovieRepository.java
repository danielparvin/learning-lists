package com.parvin.learninglists.data.works.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.works.Movie;

public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {

}
