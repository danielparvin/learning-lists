package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.history.musicalstage.OperaHistory;

@Repository
public interface OperaHistoryRepository extends PagingAndSortingRepository<OperaHistory, Long> {

}
