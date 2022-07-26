package com.parvin.learninglists.data.works.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.works.literary.Book;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

}
