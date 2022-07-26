package com.parvin.learninglists.service.lists;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.model.lists.BookList;
import com.parvin.learninglists.model.works.Book;
import com.parvin.learninglists.repository.lists.BookListRepository;
import com.parvin.learninglists.repository.works.BookRepository;

@Service
public final class BookListService extends ListService<BookListRepository, BookRepository, BookList, Book> {

}
