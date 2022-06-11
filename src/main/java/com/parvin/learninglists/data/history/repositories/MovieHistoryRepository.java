package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.history.MovieHistory;

public interface MovieHistoryRepository extends PagingAndSortingRepository<MovieHistory, Long> {

}
