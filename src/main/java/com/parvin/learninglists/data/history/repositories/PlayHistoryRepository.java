package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.history.stage.PlayHistory;

@Repository
public interface PlayHistoryRepository extends PagingAndSortingRepository<PlayHistory, Long> {

}
