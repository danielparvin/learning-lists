package com.parvin.learninglists.repositories.history;

import org.springframework.data.repository.CrudRepository;

import com.parvin.learninglists.data.history.literary.PoemHistory;

public interface PoemHistoryRepository extends CrudRepository<PoemHistory, Long> {

}
