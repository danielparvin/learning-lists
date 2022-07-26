package com.parvin.learninglists.repository.history;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.model.history.PlayHistory;

@Repository
public interface PlayHistoryRepository extends PagingAndSortingRepository<PlayHistory, Long> {

}
