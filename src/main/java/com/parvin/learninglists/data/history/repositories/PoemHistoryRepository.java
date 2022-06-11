package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.history.literary.PoemHistory;

public interface PoemHistoryRepository extends PagingAndSortingRepository<PoemHistory, Long> {

}
