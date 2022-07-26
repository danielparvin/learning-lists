package com.parvin.learninglists.repository.history;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.model.history.CompositionHistory;

@Repository
public interface CompositionHistoryRepository extends PagingAndSortingRepository<CompositionHistory, Long> {

}
