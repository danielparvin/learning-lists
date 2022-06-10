package com.parvin.learninglists.repositories.works;

import org.springframework.data.repository.CrudRepository;

import com.parvin.learninglists.data.works.literary.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
