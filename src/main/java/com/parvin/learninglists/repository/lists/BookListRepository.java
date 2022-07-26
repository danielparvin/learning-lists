package com.parvin.learninglists.repository.lists;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.model.lists.BookList;

@Repository
public interface BookListRepository extends PagingAndSortingRepository<BookList, Long> {

}
