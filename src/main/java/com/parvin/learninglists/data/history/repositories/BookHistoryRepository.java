package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.history.literary.BookHistory;

public interface BookHistoryRepository extends PagingAndSortingRepository<BookHistory, Long> {

}
