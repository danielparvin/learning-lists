package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.history.musical.CompositionHistory;

@Repository
public interface CompositionHistoryRepository extends PagingAndSortingRepository<CompositionHistory, Long> {

}
