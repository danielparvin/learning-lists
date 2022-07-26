package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.history.literary.BookHistory;

@Repository
public interface BookHistoryRepository extends PagingAndSortingRepository<BookHistory, Long> {

}
