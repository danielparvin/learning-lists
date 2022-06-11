package com.parvin.learninglists.data.works.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.works.literary.Book;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

}
