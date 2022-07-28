package com.parvin.learninglists.service.works;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.model.works.Book;
import com.parvin.learninglists.repository.works.BookRepository;

@Service
public class BookService extends WorkService<BookRepository, Book> {

}
