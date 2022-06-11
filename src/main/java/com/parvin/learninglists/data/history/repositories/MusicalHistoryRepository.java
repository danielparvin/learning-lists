package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.history.musicalstage.MusicalHistory;

public interface MusicalHistoryRepository extends PagingAndSortingRepository<MusicalHistory, Long> {

}
