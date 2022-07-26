package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.history.musicalstage.MusicalHistory;

@Repository
public interface MusicalHistoryRepository extends PagingAndSortingRepository<MusicalHistory, Long> {

}
