package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.CrudRepository;

import com.parvin.learninglists.data.history.musical.CompositionHistory;

public interface CompositionHistoryRepository extends CrudRepository<CompositionHistory, Long> {

}
