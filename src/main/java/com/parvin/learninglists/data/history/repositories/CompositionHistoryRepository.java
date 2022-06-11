package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.history.musical.CompositionHistory;

public interface CompositionHistoryRepository extends PagingAndSortingRepository<CompositionHistory, Long> {

}
