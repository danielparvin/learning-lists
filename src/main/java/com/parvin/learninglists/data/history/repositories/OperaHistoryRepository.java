package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.history.musicalstage.OperaHistory;

public interface OperaHistoryRepository extends PagingAndSortingRepository<OperaHistory, Long> {

}
