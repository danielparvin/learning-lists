package com.parvin.learninglists.data.lists.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.lists.BookList;

@Repository
public interface BookListRepository extends PagingAndSortingRepository<BookList, Long> {

}
