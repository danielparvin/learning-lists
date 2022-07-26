package com.parvin.learninglists.repository.history;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.model.history.BookHistory;

@Repository
public interface BookHistoryRepository extends PagingAndSortingRepository<BookHistory, Long> {

}
