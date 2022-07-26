package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.history.musicalstage.BalletHistory;

@Repository
public interface BalletHistoryRepository extends PagingAndSortingRepository<BalletHistory, Long> {

}
