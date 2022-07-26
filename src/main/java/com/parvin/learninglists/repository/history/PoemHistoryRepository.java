package com.parvin.learninglists.repository.history;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.model.history.PoemHistory;

@Repository
public interface PoemHistoryRepository extends PagingAndSortingRepository<PoemHistory, Long> {

}
