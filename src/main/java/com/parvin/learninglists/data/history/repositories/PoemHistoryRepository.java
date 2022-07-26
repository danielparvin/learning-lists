package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.history.literary.PoemHistory;

@Repository
public interface PoemHistoryRepository extends PagingAndSortingRepository<PoemHistory, Long> {

}
