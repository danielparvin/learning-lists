package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.history.stage.PlayHistory;

public interface PlayHistoryRepository extends PagingAndSortingRepository<PlayHistory, Long> {

}
