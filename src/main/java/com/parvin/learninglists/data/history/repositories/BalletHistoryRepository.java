package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.history.musicalstage.BalletHistory;

public interface BalletHistoryRepository extends PagingAndSortingRepository<BalletHistory, Long> {

}
