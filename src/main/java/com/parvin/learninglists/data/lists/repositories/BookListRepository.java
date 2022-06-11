package com.parvin.learninglists.data.lists.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.lists.BookList;

public interface BookListRepository extends PagingAndSortingRepository<BookList, Long> {

}
