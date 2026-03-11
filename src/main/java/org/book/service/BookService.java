package org.book.service;

import java.util.List;

import org.book.model.Book;

public interface BookService {
    Book create(Book request);

    List<Book> findAll();
    
}