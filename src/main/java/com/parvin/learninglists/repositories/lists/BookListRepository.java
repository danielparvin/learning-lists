package com.parvin.learninglists.repositories.lists;

import org.springframework.data.repository.CrudRepository;

import com.parvin.learninglists.data.lists.BookList;

public interface BookListRepository extends CrudRepository<BookList, Long> {

}
