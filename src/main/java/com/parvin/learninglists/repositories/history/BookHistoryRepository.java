package com.parvin.learninglists.repositories.history;

import org.springframework.data.repository.CrudRepository;

import com.parvin.learninglists.data.history.literary.BookHistory;

public interface BookHistoryRepository extends CrudRepository<BookHistory, Long> {

}
