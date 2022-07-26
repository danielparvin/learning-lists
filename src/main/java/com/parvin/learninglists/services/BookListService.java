package com.parvin.learninglists.services;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.data.lists.BookList;
import com.parvin.learninglists.data.lists.repositories.BookListRepository;
import com.parvin.learninglists.data.works.literary.Book;
import com.parvin.learninglists.data.works.repositories.BookRepository;

@Service
public final class BookListService extends ListService<BookListRepository, BookRepository, BookList, Book> {

}
