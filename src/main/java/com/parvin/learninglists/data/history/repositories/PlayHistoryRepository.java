package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.CrudRepository;

import com.parvin.learninglists.data.history.stage.PlayHistory;

public interface PlayHistoryRepository extends CrudRepository<PlayHistory, Long> {

}
