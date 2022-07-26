package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.history.MovieHistory;

@Repository
public interface MovieHistoryRepository extends PagingAndSortingRepository<MovieHistory, Long> {

}
