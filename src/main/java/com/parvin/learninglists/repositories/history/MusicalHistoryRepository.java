package com.parvin.learninglists.repositories.history;

import org.springframework.data.repository.CrudRepository;

import com.parvin.learninglists.data.history.musicalstage.MusicalHistory;

public interface MusicalHistoryRepository extends CrudRepository<MusicalHistory, Long> {

}
