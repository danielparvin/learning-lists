package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.CrudRepository;

import com.parvin.learninglists.data.history.MovieHistory;

public interface MovieHistoryRepository extends CrudRepository<MovieHistory, Long> {

}
